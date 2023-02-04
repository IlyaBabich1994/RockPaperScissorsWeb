package com.example.rockpaperscissorsweb.model;

import com.example.rockpaperscissorsweb.annotation.Default;

import java.util.Objects;


public final class GameDTO {
    private final int lastRound;
    private final ScoreDTO score;
    private final int maxRound;

    public int getLastRound() {
        return lastRound;
    }

    public ScoreDTO getScore() {
        return new ScoreDTO(this.score);
    }

    public int getMaxRound() {
        return maxRound;
    }
    @Default
    public GameDTO(int lastRound, ScoreDTO score, int maxRound) {
        this.lastRound = lastRound;
        this.score = score;
        this.maxRound = maxRound;
    }

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
}
