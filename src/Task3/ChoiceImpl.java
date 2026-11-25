package Task3;

import java.util.Arrays;

public class ChoiceImpl implements IContainer {
    private double[] data;

    public ChoiceImpl(double[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    public double[] getData() {
        return Arrays.copyOf(data, data.length);
    }

    @Override
    public void sort() {
        int n = data.length;
        for (int i = n - 1; i > 0; i--) {
            int maxIdx = 0;
            for (int j = 1; j <= i; j++) {
                if (data[j] > data[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = data[i];
            data[i] = data[maxIdx];
            data[maxIdx] = temp;
        }
    }

    @Override
    public double norma() {
        if (data.length == 0) return 0;
        double sum = 0;
        for (double val : data) {
            sum += val;
        }
        return sum / data.length;
    }

    @Override
    public String toString() {
        return "ChoiceImpl" + Arrays.toString(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChoiceImpl)) return false;
        ChoiceImpl that = (ChoiceImpl) o;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}