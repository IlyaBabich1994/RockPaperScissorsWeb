package com.example.rockpaperscissorsweb.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;


public class GameDTO {
    private int lastRound;
    private ScoreDTO score;
    private int maxRound;

    @Override
    public String toString() {
        return "GameDTO{" +
                "lastRound=" + lastRound +
                ", score=" + score +
                ", maxRound=" + maxRound +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDTO gameDTO = (GameDTO) o;
        return lastRound == gameDTO.lastRound && maxRound == gameDTO.maxRound && Objects.equals(score, gameDTO.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastRound, score, maxRound);
    }

    public int getLastRound() {
        return lastRound;
    }

    public ScoreDTO getScore() {
        return score;
    }

    public int getMaxRound() {
        return maxRound;
    }

    public GameDTO(int lastRound, ScoreDTO score, int maxRound) {
        this.lastRound = lastRound;
        this.score = score;
        this.maxRound = maxRound;
    }
}
