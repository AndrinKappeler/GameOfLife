package ch.kappeler;

class CellGrid {

    private boolean[][] cellGridStates;

    CellGrid(boolean[][] cellGridStates) {
        this.cellGridStates = cellGridStates;
    }

    boolean[][] getStates() {
        return cellGridStates;
    }

    void update() {
        final int ROW_LENGTH = this.cellGridStates.length;
        final int COL_LENGTH = this.cellGridStates[0].length;

        boolean[][] newCellGrid = new boolean[ROW_LENGTH][COL_LENGTH];

        for (int row = 0; row < ROW_LENGTH; row++) {
            for (int col = 0; col < COL_LENGTH; col++) {
                int numberOfAliveNeighbors = getNumberOfAliveNeighbors(this.cellGridStates, row, col);
                newCellGrid[row][col] = LifeCalculator.isAlive(this.cellGridStates[row][col], numberOfAliveNeighbors);
            }
        }

        this.cellGridStates = newCellGrid;
    }

    private int getNumberOfAliveNeighbors(boolean[][] cellStates, int row, int col) {
        int numberOfAliveNeighbour = 0;
        numberOfAliveNeighbour += getNumberOfAliveNeighboursInRow(cellStates, row - 1, col);   // row above
        numberOfAliveNeighbour += returnOneIfCellIsAlive(cellStates, row, col - 1);             // col left
        numberOfAliveNeighbour += returnOneIfCellIsAlive(cellStates, row, col + 1);             // col right
        numberOfAliveNeighbour += getNumberOfAliveNeighboursInRow(cellStates, row + 1, col);   // col below
        return numberOfAliveNeighbour;
    }

    private int getNumberOfAliveNeighboursInRow(boolean[][] cellStates, int row, int col) {
        int numberOfAliveNeighbor = 0;
        // The cells outside of the border are dead.
        if (row >= 0 && row < cellStates.length) {
            numberOfAliveNeighbor += returnOneIfCellIsAlive(cellStates, row, col - 1);          // col above
            numberOfAliveNeighbor += returnOneIfCellIsAlive(cellStates, row, col);                  // col in middle
            numberOfAliveNeighbor += returnOneIfCellIsAlive(cellStates, row, col + 1);          // col below
        }
        return numberOfAliveNeighbor;
    }

    private int returnOneIfCellIsAlive(boolean[][] state, int row, int col) {
        // The cells outside of the border are dead.
        if (col >= 0 && col < state[row].length) {
            if (state[row][col]) {
                return 1;
            }
        }
        return 0;
    }
}
