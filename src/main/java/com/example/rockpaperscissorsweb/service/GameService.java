package com.example.rockpaperscissorsweb.service;

import com.example.rockpaperscissorsweb.exception.GameNotStartedException;
import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.RockPaperScissors;
import com.example.rockpaperscissorsweb.model.Score;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService implements GameServiceImpl {
    @Value("${count.game}")
    private int countRound;
    private Game game;

    @Override
    public Game playRound(final String choice) {
        if (game == null) {
            throw new GameNotStartedException("Game not started");
        }
        if (isFinishedRound()) {
            return game;
        }
        RockPaperScissors playerChoice = RockPaperScissors.valueOf(choice);
        int random = new Random().nextInt(3);
        RockPaperScissors compChoice = RockPaperScissors.values()[random];
        this.game = new Game(
                this.game.getLastRound() + 1,
                defineWinner(this.game.getScore(), playerChoice, compChoice),
                this.game.getMaxRound());

        return game;
    }

    @Override
    public Game startNewGame(final Game game) {
        this.game = game == null ? new Game(0, new Score(), countRound) : new Game(game);
        return this.game;
    }

    @Override
    public Game startNewGame() {
        this.game = new Game(0, new Score(), countRound);
        return this.game;
    }

    private boolean isFinishedRound() {
        return (game.getMaxRound() - game.getLastRound()) <= 0;
    }

    @Override
    public Score finishGame() {
        Score score = game.getScore();
        this.game = null;
        return score;
    }

    private Score defineWinner(Score score, RockPaperScissors player, RockPaperScissors computer) {
        int winner = whiIsStronger(player, computer);
        if (winner > 0) {
            return new Score(score.getScoreComp(), score.getTie(), score.getScorePlayer() + 1);
        } else if (winner < 0) {
            return new Score(score.getScoreComp() + 1, score.getTie(), score.getScorePlayer());
        } else {
            return new Score(score.getScoreComp(), score.getTie() + 1, score.getScorePlayer());
        }
    }

    private int whiIsStronger(final RockPaperScissors firstPlayer, final RockPaperScissors secondPlayer) {
        int difference = firstPlayer.ordinal() - secondPlayer.ordinal();
        if (difference == 1 || difference == -2) {
            return 1;
        } else if (difference == 2 || difference == -1) {
            return -1;
        } else return 0;
    }
}
