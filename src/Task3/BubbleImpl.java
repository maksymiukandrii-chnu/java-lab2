package Task3;

import java.util.Arrays;

public class BubbleImpl implements IContainer {
    private double[] data;

    public BubbleImpl(double[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public double[] getData() {
        return Arrays.copyOf(data, data.length);
    }

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
        return "BubbleImpl" + Arrays.toString(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BubbleImpl)) return false;
        BubbleImpl that = (BubbleImpl) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}