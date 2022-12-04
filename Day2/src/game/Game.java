package game;

import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> scores = new ArrayList<Integer>();

    public void addRoundScore(int score) {
        this.scores.add(score);
    }

    public int getScoreFromRound(int index) {
        return this.scores.get(index - 1);
    }

    public int getTotalScore() {
        return this.scores.stream().mapToInt(i -> i.intValue()).sum();
    }
}
