package ch.kappeler;

class LifeCalculator {

    static boolean isAlive(boolean isAlive, int neighbourCells) {
        if (isAlive) {
            isAlive = neighbourCells > 1 && neighbourCells < 4;
        } else {
            isAlive = neighbourCells == 3;
        }
        return isAlive;
    }
}
