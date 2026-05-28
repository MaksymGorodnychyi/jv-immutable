package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(String color, Engine engine, List<Wheel> wheels, int year) {
        this.engine = new Engine(engine);
        this.color = color;
        this.wheels = wheels.stream().map(Wheel::new).toList();
        this.year = year;

    }

    public Car changeEngine(Engine engine) {
        return new Car(color, engine, wheels, year);
    }

    public Car changeColor(String color) {
        return new Car(color, engine, wheels, year);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = new ArrayList<>(wheels);
        newWheels.add(new Wheel(wheel));
        return new Car(color, engine, newWheels, year);
    }

    public int getYear() {
        return year;
    }

    public List<Wheel> getWheels() {
        return wheels.stream().map(Wheel::new).toList();
    }

    public Engine getEngine() {
        return new Engine(engine);
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }
}
