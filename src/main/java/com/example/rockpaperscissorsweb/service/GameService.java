package com.example.rockpaperscissorsweb.service;

import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.RockPaperScissors;
import com.example.rockpaperscissorsweb.model.Score;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService implements GameServiceImpl{
    @Value("${count.game}")
    private int countRound;
    private Game game;

    @Override
    public Game playRound(String choice) {
        if(game.isFinishedRound()) {
            return game;
        }
        RockPaperScissors playerChoice = RockPaperScissors.valueOf(choice);
        int random = new Random().nextInt(3);
        RockPaperScissors compChoice = RockPaperScissors.values()[random];
        game.getScore().defineWinner(playerChoice, compChoice);;
        game.nextRound();
        return game;
    }

    @Override
    public Game startNewGame() {
        this.game = new Game(0, new Score(), countRound);
        return this.game;
    }

    @Override
    public Score finishGame() {
        return game.getScore();
    }
}
