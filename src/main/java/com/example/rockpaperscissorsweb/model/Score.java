package com.example.rockpaperscissorsweb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;


public final class Score {
    private int scoreComp = 0;
    private int tie = 0;
    private int scorePlayer = 0;

    public Score defineWinner(RockPaperScissors player, RockPaperScissors computer) {
        if(player.whoIsStrengether(computer) > 0) {
            scorePlayer++;
        } else if (player.whoIsStrengether(computer) < 0) {
            scoreComp++;
        } else {
            tie++;
        }
        return this;
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
