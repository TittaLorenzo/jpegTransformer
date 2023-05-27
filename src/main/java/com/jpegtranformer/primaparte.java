package com.jpegtranformer;

import java.util.Random;

import org.jtransforms.dct.DoubleDCT_2D;

public class primaparte {
    public static void main(String[] args) {
        int n = 20000;
        double[][] f = new double[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = rand.nextInt(255);
            }
        }
        System.out.println();
        System.out.println("nostra:");
        // mineDtc2(f);
        DoubleDCT_2D dct = new DoubleDCT_2D(n, n);
        long startTime = System.currentTimeMillis();
        dct.forward(f, true);
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println();
        System.out.println("libreria:");
        System.out.println();
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++)
        // System.out.printf("%f\t", f[i][j]);
        // System.out.println();
        // }
        System.out.println(((double) endTime - (double) startTime) + " millisec)");
        System.out.println(((double) endTime - (double) startTime) / 1000 + " sec)");
    }

    public static void mineDtc2(double[][] f) {
        long startTime = System.currentTimeMillis();
        double n = f[0].length;
        int ni = (int) n;
        double[][] c = new double[ni][ni];
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                float res = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        res += f[i][j]
                                * Math.cos(Math.PI * k * (2 * i + 1) / (2 * n))
                                * Math.cos(Math.PI * l * (2 * j + 1) / (2 * n));
                    }
                }
                double alphak = 0;
                double alphal = 0;
                if (k == 0) {
                    alphak = 1 / Math.sqrt(n);
                } else {
                    alphak = Math.sqrt(2) / Math.sqrt(n);
                }
                if (l == 0) {
                    alphal = 1 / Math.sqrt(n);
                } else {
                    alphal = Math.sqrt(2) / Math.sqrt(n);
                }
                c[k][l] = alphak * alphal * res;
            }
        }
        long endTime = System.currentTimeMillis();
        // for (int i = 0; i < n; i++) {
        // System.out.println();
        // for (int j = 0; j < n; j++) {
        // System.out.printf("%f\t", c[i][j]);
        // }
        // }
        System.out.println();
        System.out.println(((double) endTime - (double) startTime) + " millisec)");
        System.out.println(((double) endTime - (double) startTime) / 1000 + " sec)");
    }
}
