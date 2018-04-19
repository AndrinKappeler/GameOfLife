package ch.kappeler;

class CellGrid implements Universe {

    private boolean[][] cellGridStates;

    CellGrid(boolean[][] cellGridStates) {
        this.cellGridStates = cellGridStates;
    }

    public boolean[][] getStates() {
        return cellGridStates;
    }

    public void update() {
        final int ROW_LENGTH = this.cellGridStates.length;
        final int COL_LENGTH = this.cellGridStates[0].length;

        boolean[][] newCellGrid = new boolean[ROW_LENGTH][COL_LENGTH];

        for (int row = 0; row < ROW_LENGTH; row++) {
            for (int col = 0; col < COL_LENGTH; col++) {
                newCellGrid[row][col] = LifeCalculator.isAlive(this.cellGridStates[row][col], getNumberOfAliveNeighbors(row, col));
            }
        }

        this.cellGridStates = newCellGrid;
    }

    private int getNumberOfAliveNeighbors(int row, int col) {
        int numberOfAliveNeighbor = 0;
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(row - 1, col);   // row above
        if (isCellAlive(row, col - 1)) numberOfAliveNeighbor++;                   // col left
        if (isCellAlive(row, col + 1)) numberOfAliveNeighbor++;                   // col right
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(row + 1, col);   // col below
        return numberOfAliveNeighbor;
    }

    private int getNumberOfAliveNeighborsInRow(int row, int col) {
        int numberOfAliveNeighbor = 0;
        if (isCellAlive(row, col - 1)) numberOfAliveNeighbor++;               // col left
        if (isCellAlive(row, col)) numberOfAliveNeighbor++;                       // col middle
        if (isCellAlive(row, col + 1)) numberOfAliveNeighbor++;               // col right
        return numberOfAliveNeighbor;
    }


    private boolean isCellAlive(int row, int col) {
        if (areCellsAround(row, col)) {
            return cellGridStates[row][col];
        } else {
            // The cells outside of the border are dead.
            return false;
        }
    }

    private boolean areCellsAround(int row, int col) {
        return row >= 0 && row < cellGridStates.length && col >= 0 && col < cellGridStates[row].length;
    }
}
