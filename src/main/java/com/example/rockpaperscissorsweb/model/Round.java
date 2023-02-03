package com.example.rockpaperscissorsweb.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Round {
    private Score score;
    private String winner;

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
