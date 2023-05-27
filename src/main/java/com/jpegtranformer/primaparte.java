package com.jpegtranformer;

import org.jtransforms.dct.DoubleDCT_2D;

public class primaparte {
    public static void main(String[] args) {
        int n = 8;
        // double[][] f = new double[n][n];
        double[][] f = { { 231, 32, 233, 161, 24, 71, 140, 245 }, { 247, 40, 248, 245, 124, 204, 36, 107 },
                { 234, 202, 245, 167, 9, 217, 239, 173 }, { 193, 190, 100, 167, 43, 180, 8, 70 },
                { 11, 24, 210, 177, 81, 243, 8, 112 }, { 97, 195, 203, 47, 125, 114, 165, 182 },
                { 193, 70, 174, 167, 41, 30, 127, 245 }, { 87, 149, 57, 192, 65, 129, 178, 228 } };
        System.out.println("nostra:");
        mineDtc2(f);
        DoubleDCT_2D dct = new DoubleDCT_2D(n, n);
        dct.forward(f, true);
        System.out.println();
        System.out.println();
        System.out.println("libreria:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%f\t", f[i][j]);
            System.out.println();
        }

    }

    public static void mineDtc2(double[][] f) {
        double n = f[0].length;
        int ni = (int) n;
        double[][] c = new double[ni][ni];
        double[][] alpha = new double[ni][ni];
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                float res = 0;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        res += f[i][j] * Math.cos(Math.PI * k * ((2 * i + 1) / 2 * n))
                                * Math.cos(Math.PI * l * ((2 * j + 1) / 2 * n));
                    }
                }
                if (k == 0 || l == 0) {
                    if (k == 0 && l == 0) {
                        alpha[k][l] = 1 / n;
                    } else {
                        alpha[k][l] = Math.sqrt(2 / (n * n));
                    }
                } else {
                    alpha[k][l] = 2 / n;
                }
                c[k][l] = alpha[k][l] * res;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(c[i][j] + " ");
            }
        }
    }
}
