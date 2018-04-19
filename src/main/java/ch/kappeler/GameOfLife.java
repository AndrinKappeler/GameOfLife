package ch.kappeler;

public class GameOfLife implements Game<Void> {

    private Universe universe;

    public GameOfLife(Universe universe) {
        this.universe = universe;
    }

    public void update(Void aVoid) {
        universe.update();
    }

    public Boolean isRunning() {
        return true;
    }

    public void render() {

    }
}
