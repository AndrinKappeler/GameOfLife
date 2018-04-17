package ch.kappeler;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CellGridTest {
    private static final boolean A = true;
    private static final boolean D = false;

    @Test
    public void test_updateAllCells() {
        CellGrid cellGrid = new CellGrid(new boolean[][]{
                {D, A, A},
                {A, D, A},
                {D, D, A},
        });
        boolean[][] expectedStates = new boolean[][]{
                {D, A, A},
                {D, D, A},
                {D, A, D}
        };
        boolean[][] actualStates = getNextState(cellGrid);
        assertArrayEquals(expectedStates, actualStates);
    }

    @Test
    public void test_cellDiesBecauseOfToManyCellsAround() {
        CellGrid cellGrid = new CellGrid(new boolean[][]{
                {A, A, A},
                {A, A, A},
                {A, A, A},
        });
        boolean[][] expectedStates = new boolean[][]{
                {A, D, A},
                {D, D, D},
                {A, D, A}
        };
        boolean[][] actualStates = getNextState(cellGrid);
        assertArrayEquals(expectedStates, actualStates);
    }

    @Test
    public void test_smallExploder() {
        CellGrid cellGrid = new CellGrid(new boolean[][]{
                {D, D, D, D, D},
                {D, D, A, D, D},
                {D, A, A, A, D},
                {D, A, D, A, D},
                {D, D, A, D, D},
        });
        boolean[][] expectedStates = new boolean[][]{
                {D, D, D, D, D},
                {D, A, A, A, D},
                {D, A, D, A, D},
                {D, A, D, A, D},
                {D, D, A, D, D},
        };
        boolean[][] actualStates = getNextState(cellGrid);
        assertArrayEquals(expectedStates, actualStates);
    }

    private boolean[][] getNextState(CellGrid cellGrid) {
        cellGrid.update();
        return cellGrid.getStates();
    }
}
