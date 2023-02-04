package com.example.rockpaperscissorsweb.service;

import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.Score;

public interface GameServiceImpl {

    Game playRound(String choice);

    Game startNewGame(Game game);

    Game startNewGame();

    Score finishGame();
}
