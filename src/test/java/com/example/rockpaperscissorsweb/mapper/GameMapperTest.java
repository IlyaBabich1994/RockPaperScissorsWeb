package com.example.rockpaperscissorsweb.mapper;

import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.GameDTO;
import com.example.rockpaperscissorsweb.model.Score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class GameMapperTest {
    private ScoreMapper scoreMapper = new ScoreMapperImpl();
    private GameMapper gameMapper = new GameMapperImpl(scoreMapper);

    @Test
    void toGameDTO() {
        System.out.println(gameMapper);
        Game game = new Game(0, new Score(), 100);
        GameDTO gameDTO = gameMapper.toGameDTO(game);
        assertEquals(gameDTO.getScore().getScoreComp(), game.getScore().getScoreComp());
        assertEquals(gameDTO.getScore().getScorePlayer(), game.getScore().getScorePlayer());
        assertEquals(gameDTO.getScore().getTie(), game.getScore().getTie());
        assertEquals(gameDTO.getLastRound(), game.getLastRound());
        assertEquals(gameDTO.getMaxRound(), game.getMaxRound());
    }
}