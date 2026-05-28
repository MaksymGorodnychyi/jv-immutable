package core.basesyntax;

public class Wheel {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public Wheel(Wheel wheel) {
        this.radius = wheel.radius;
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}
