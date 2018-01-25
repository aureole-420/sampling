package com.company;

import java.util.Random;

public class WeightedRandomSampling<T> {

    T[] items;
    double[] CDF; // cumulative density function
    Random random;

    public WeightedRandomSampling(double[] weights, T[] items) {
        this.items = items;
        this.random = new Random();
        this.CDF = new double[weights.length];
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            CDF[i] = sum;
        }
        for (int i = 0; i < weights.length; i++) {
            CDF[i] /= sum;
        }
    }

    public T sample() {
        double toss = random.nextDouble();
        int index = 0;
        while (index < CDF.length) {
            if (toss < CDF[index]) {
                break;
            }
            index++;
        }
        return items[index];
    }
}
