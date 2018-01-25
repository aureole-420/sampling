package com.company;

public class Main {

    public static void main(String[] args) {
        double[] weights = new double[]{3, 7};
        Integer[] items = new Integer[] {1,2};
        WeightedRandomSampling<Integer> wrs = new WeightedRandomSampling<>(weights, items);

        for (int i = 0; i < 10; i++) {
            System.out.print(wrs.sample());
        }
    }
}
