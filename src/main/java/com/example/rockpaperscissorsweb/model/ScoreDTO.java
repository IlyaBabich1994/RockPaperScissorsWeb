package com.example.rockpaperscissorsweb.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
public class ScoreDTO {
    private int scoreComp;
    private int tie;
    private int scorePlayer;

    public ScoreDTO(int scoreComp, int tie, int scorePlayer) {
        this.scoreComp = scoreComp;
        this.tie = tie;
        this.scorePlayer = scorePlayer;
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
