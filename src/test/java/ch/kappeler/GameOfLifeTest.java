package ch.kappeler;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameOfLifeTest {

    @Test
    public void test_invokeUpdateOfUniverse() {
        Universe universe = mock(Universe.class);
        Game<Void> game = new GameOfLife(universe);
        game.update(null);
        verify(universe).update();
    }

    @Test
    public void test_alwaysRunning() {
        GameOfLife gameOfLife = new GameOfLife(null);
        assertTrue(gameOfLife.isRunning());
    }
}
