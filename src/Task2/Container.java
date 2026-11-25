package Task2;

import java.util.Arrays;

public abstract class Container {
    protected double[] data;

    public Container(double[] data) {
        // Копіювання масиву для захисту внутрішнього стану
        this.data = Arrays.copyOf(data, data.length);
    }

    public double[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    public abstract void sort();

    public abstract double norma();
}