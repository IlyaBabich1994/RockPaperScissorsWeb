package com.example.rockpaperscissorsweb.mapper;

import com.example.rockpaperscissorsweb.model.Game;
import com.example.rockpaperscissorsweb.model.GameDTO;
import com.example.rockpaperscissorsweb.model.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameMapperTest {
    private final ScoreMapper scoreMapper = new ScoreMapperImpl();
    private final GameMapper gameMapper = new GameMapperImpl(scoreMapper);

    @DisplayName("Should map Game to the correct GameDTO")
    @ParameterizedTest(name = "lastRound={0}, scoreComp={1}, tie={2}, scorePlayer={3}, maxRound={4}")
    @MethodSource("dataProvider")
    void toGameDTOWithScoreTest(int lastRound, int scoreComp, int tie, int scorePlayer, int maxRound) {
        Game game = new Game(lastRound, new Score(scoreComp, tie, scorePlayer), maxRound);
        GameDTO gameDTO = gameMapper.toGameDTO(game);
        assertEquals(gameDTO.getScore().getScoreComp(), game.getScore().getScoreComp());
        assertEquals(gameDTO.getScore().getScorePlayer(), game.getScore().getScorePlayer());
        assertEquals(gameDTO.getScore().getTie(), game.getScore().getTie());
        assertEquals(gameDTO.getLastRound(), game.getLastRound());
        assertEquals(gameDTO.getMaxRound(), game.getMaxRound());
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(48, 12, 12, 24, 100),
                Arguments.of(5, 2, 3, 2, 1)
        );
    }
}