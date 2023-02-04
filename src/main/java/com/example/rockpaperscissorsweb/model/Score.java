package com.example.rockpaperscissorsweb.model;

import com.example.rockpaperscissorsweb.annotation.Default;

import java.util.Objects;


public final class Score {
    private final int scoreComp;
    private final int tie;
    private final int scorePlayer;

    public Score() {
        this.scoreComp = 0;
        this.tie = 0;
        this.scorePlayer = 0;
    }

    public Score(final Score score) {
        this.scoreComp = score.getScoreComp();
        this.tie = score.getTie();
        this.scorePlayer = score.getScorePlayer();
    }

    @Default
    public Score(final int scoreComp, final int tie, final int scorePlayer) {
        this.scoreComp = scoreComp;
        this.tie = tie;
        this.scorePlayer = scorePlayer;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreComp=" + scoreComp +
                ", tie=" + tie +
                ", scorePlayer=" + scorePlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return scoreComp == score.scoreComp && tie == score.tie && scorePlayer == score.scorePlayer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreComp, tie, scorePlayer);
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
}
