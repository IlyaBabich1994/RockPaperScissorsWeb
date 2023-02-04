package com.example.rockpaperscissorsweb.model;

import com.example.rockpaperscissorsweb.annotation.Default;

import java.util.Objects;

public final class ScoreDTO {
    private final int scoreComp;
    private final int tie;
    private final int scorePlayer;
    @Default
    public ScoreDTO(final int scoreComp, final int tie, final int scorePlayer) {
        this.scoreComp = scoreComp;
        this.tie = tie;
        this.scorePlayer = scorePlayer;
    }

    public ScoreDTO(final ScoreDTO scoreDTO) {
        this.scoreComp = scoreDTO.getScoreComp();
        this.tie = scoreDTO.getTie();
        this.scorePlayer = scoreDTO.getScorePlayer();
    }

    public int getScoreComp() {
        return scoreComp;
    }

    public int getTie() {
        return tie;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "scoreComp=" + scoreComp +
                ", tie=" + tie +
                ", scorePlayer=" + scorePlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreDTO scoreDTO = (ScoreDTO) o;
        return scoreComp == scoreDTO.scoreComp && tie == scoreDTO.tie && scorePlayer == scoreDTO.scorePlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreComp, tie, scorePlayer);
    }
}
