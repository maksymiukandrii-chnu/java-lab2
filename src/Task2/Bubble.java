package Task2;

import java.util.Arrays;

public class Bubble extends Container {
    public Bubble(double[] data) {
        super(data);
    }

    // Бульбашкове сортування
    @Override
    public void sort() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    double temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Квадратний корінь із суми елементів
    @Override
    public double norma() {
        double sum = 0;
        for (double val : data) {
            sum += val;
        }
        return sum >= 0 ? Math.sqrt(sum) : Double.NaN;
    }

    @Override
    public String toString() {
        return "Bubble" + Arrays.toString(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bubble)) return false;
        Bubble bubble = (Bubble) o;
        return Arrays.equals(data, bubble.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}