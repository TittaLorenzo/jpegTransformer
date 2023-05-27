package com.jpegtranformer;


public class primaparte {
    public static void main(String[] args) {

        // double[][] f = new double[n][n];
        double[][] f = { { 8, 2, 3 }, { 5, 2, 6 }, { 7, 8, 9 } };
        mineDtc2(f);
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
                System.out.println(alpha[k][l]);
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
