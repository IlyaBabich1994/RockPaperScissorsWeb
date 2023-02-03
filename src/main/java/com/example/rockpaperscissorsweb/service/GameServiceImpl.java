package com.example.rockpaperscissorsweb.service;

import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.Round;
import com.example.rockpaperscissorsweb.model.Score;
import org.springframework.stereotype.Component;

public interface GameServiceImpl {

    Game playRound(String choice);

    Game startNewGame();

    Score finishGame();
}
