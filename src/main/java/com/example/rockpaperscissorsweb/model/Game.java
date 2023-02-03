package com.example.rockpaperscissorsweb.model;

import lombok.*;

import java.util.Objects;

public class Game {
    private int lastRound;
    private Score score;
    private int maxRound;

    public Game(int lastRound, Score score, int maxRound) {
        this.lastRound = lastRound;
        this.score = score;
        this.maxRound = maxRound;
    }

    public int nextRound() {
        return ++lastRound;
    }

    public boolean isFinishedRound() {
        return (maxRound - lastRound) <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return lastRound == game.lastRound && maxRound == game.maxRound && Objects.equals(score, game.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastRound, score, maxRound);
    }

    public int getLastRound() {
        return lastRound;
    }

    public Score getScore() {
        return score;
    }

    public int getMaxRound() {
        return maxRound;
    }
}
