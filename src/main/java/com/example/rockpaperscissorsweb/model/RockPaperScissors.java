package com.example.rockpaperscissorsweb.model;

public enum RockPaperScissors {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String choice;
    RockPaperScissors(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public int whoIsStrengether(RockPaperScissors o) {
        if((ordinal() - o.ordinal()) == 1 || (ordinal() - o.ordinal()) == -2) {
            return 1;
        } else if ((ordinal() - o.ordinal()) == 2 || (ordinal() - o.ordinal()) == -1 ) {
            return -1;
        } else return 0;
    }
}
