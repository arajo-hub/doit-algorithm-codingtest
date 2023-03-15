package chapter3;

import java.io.IOException;
import java.util.Scanner;

public class Q094 {

    static int n;

    static Matrix[] m;

    static int[][] d;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        m = new Matrix[n + 1];
        d = new int[n + 1][n + 1];

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();

            m[i] = new Matrix(y, x);
        }

        System.out.println(execute(1, n));
    }

    static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;

        if (d[s][e] != -1) {
            return d[s][e];
        }
        if (s == e) {
            return 0;
        }
        if (s + 1 == e) {
            return m[s].y * m[s].x * m[e].x;
        }

        for (int i = s; i < e; i++) {
            result = Math.min(result, m[s].y * m[i].x * m[e].x + execute(s, i) + execute(i + 1, e));
        }
        d[s][e] = result;
        return d[s][e];
    }

    static class Matrix {
        private int y;
        private int x;

        Matrix(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
