package com.example.rockpaperscissorsweb.mapper;

import com.example.rockpaperscissorsweb.model.Score;
import com.example.rockpaperscissorsweb.model.ScoreDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreMapperTest {
    private final ScoreMapper scoreMapper = new ScoreMapperImpl();

    @DisplayName("Should map Score to the correct ScoreDTO")
    @ParameterizedTest(name = "a={0}, b={1}, sum={2}")
    @MethodSource("dataProvider")
    void toScoreDTOTest() {
        Score score = new Score(13, 13, 12);
        ScoreDTO scoreDTO = scoreMapper.toScoreDTO(score);
        assertEquals(scoreDTO.getScoreComp(), score.getScoreComp());
        assertEquals(scoreDTO.getScorePlayer(), score.getScorePlayer());
        assertEquals(scoreDTO.getTie(), score.getTie());
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5)
        );
    }

}