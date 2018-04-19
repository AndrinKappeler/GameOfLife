package ch.kappeler;

class LifeCalculator {

    static boolean isAlive(boolean isAlive, int NeighborCells) {
        if (isAlive) {
            isAlive = NeighborCells > 1 && NeighborCells < 4;
        } else {
            isAlive = NeighborCells == 3;
        }
        return isAlive;
    }
}
