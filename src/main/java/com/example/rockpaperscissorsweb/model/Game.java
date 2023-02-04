package com.example.rockpaperscissorsweb.model;

import com.example.rockpaperscissorsweb.annotation.Default;

import java.util.Objects;

public final class Game {
    private final int lastRound;
    private final Score score;
    private final int maxRound;

    @Default
    public Game(final int lastRound, final Score score, final int maxRound) {
        this.lastRound = lastRound;
        this.score = new Score(score);
        this.maxRound = maxRound;
    }

    public Game(final Game game) {
        this.lastRound = game.getLastRound();
        this.score = new Score(game.getScore());
        this.maxRound = game.getMaxRound();
    }

    public int getLastRound() {
        return lastRound;
    }

    public Score getScore() {
        return new Score(score);
    }

    public int getMaxRound() {
        return maxRound;
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

    @Override
    public String toString() {
        return "Game{" +
                "lastRound=" + lastRound +
                ", score=" + score +
                ", maxRound=" + maxRound +
                '}';
    }
}
