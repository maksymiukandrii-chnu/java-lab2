package Task2;

import java.util.Arrays;

public class Choice extends Container {
    public Choice(double[] data) {
        super(data);
    }

    // Сортування методом вибору максимального елемента
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

    // Середнє арифметичне всіх елементів
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
        return "Choice" + Arrays.toString(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Choice)) return false;
        Choice choice = (Choice) o;
        return Arrays.equals(data, choice.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}