package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.Game;
import main.App;

public class AppTest {
    @Test
    public void firstRoundScoreIs8() throws Exception {
        Game game = App.calculateGameResult();
        assertEquals(8, game.getScoreFromRound(1));
    }

    @Test
    public void secondRoundScoreIs1() throws Exception {
        Game game = App.calculateGameResult();
        assertEquals(1, game.getScoreFromRound(2));
    }

    @Test
    public void thirdRoundScoreIs6() throws Exception {
        Game game = App.calculateGameResult();
        assertEquals(6, game.getScoreFromRound(3));
    }

    @Test
    public void totalScoreIs15() throws Exception {
        Game game = App.calculateGameResult();
        assertEquals(15, game.getTotalScore());
    }

    @Test
    public void firstRoundSecretStrategyScoreIs4() throws Exception {
        Game game = App.calculateGameResultWithSecretStrategy();
        assertEquals(4, game.getScoreFromRound(1));
    }

    @Test
    public void secondRoundSecretStrategyScoreIs1() throws Exception {
        Game game = App.calculateGameResultWithSecretStrategy();
        assertEquals(1, game.getScoreFromRound(2));
    }

    @Test
    public void thirdRoundSecretStrategyScoreIs7() throws Exception {
        Game game = App.calculateGameResultWithSecretStrategy();
        assertEquals(7, game.getScoreFromRound(3));
    }

    @Test
    public void totalScoreWithSecretStrategyIs12() throws Exception {
        Game game = App.calculateGameResultWithSecretStrategy();
        assertEquals(12, game.getTotalScore());
    }
}
