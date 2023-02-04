package com.example.rockpaperscissorsweb.service;

import com.example.rockpaperscissorsweb.exception.GameNotStartedException;
import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class GameServiceImplTest {
    @Autowired
    private GameService gameService;
    private Game game;

    @Test
    @DisplayName("Must return the same Game")
    void roundIsFinished() {
        game = new Game(100, new Score(33, 33, 34), 100);
        gameService.startNewGame(game);
        Game nextStatement = gameService.playRound("ROCK");
        assertEquals(game.getLastRound(), nextStatement.getLastRound());
        assertEquals(game.getScore(), nextStatement.getScore());
        assertEquals(game.getMaxRound(), nextStatement.getMaxRound());
    }

    @Test
    @DisplayName("Must change the Game")
    void playNextRound() {
        game = new Game(50, new Score(33, 33, 34), 100);
        gameService.startNewGame(game);
        Game nextStatement = gameService.playRound("ROCK");
        assertEquals(game.getLastRound() + 1, nextStatement.getLastRound());
        assertNotEquals(game.getScore(), nextStatement.getScore());
        assertEquals(game.getMaxRound(), nextStatement.getMaxRound());
    }

    @Test
    @DisplayName("Должен создать игру, а в случае вызова следуюшего раунда отдать ошибку")
    void newGameTest() {
        GameNotStartedException thrown = Assertions.assertThrows(GameNotStartedException.class, () -> {
            gameService.playRound("ROCK");
        }, "Game not started");
        Assertions.assertEquals("Game not started", thrown.getMessage());
        game = gameService.startNewGame();
        Assertions.assertDoesNotThrow(() -> gameService.playRound("ROCK"));
    }

    @Test
    @DisplayName("Должен вывести последний счет.")
    void finishGame() {
        game = new Game(50, new Score(33, 33, 34), 100);
        gameService.startNewGame(game);
        Score score = gameService.finishGame();
        assertEquals(score, game.getScore());
    }
}