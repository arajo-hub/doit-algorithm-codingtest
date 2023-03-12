package chapter3;

import java.io.IOException;
import java.util.Scanner;

public class Q093 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][][] dp = new int[100001][5][5];

        int[][] mp = {{0, 2, 2, 2, 2}, {2, 1, 3, 4, 3}, {2, 3, 1, 3, 4}, {2, 4, 3, 1, 3}, {2, 3, 4, 3, 1}};

        int n = 0;
        int s = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++) {
                    dp[k][i][j] = 100001 * 4;
                }
            }
        }

        dp[0][0][0] = 0;

        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }

            for (int i = 0; i < 5; i++) {
                if (n == i) {
                    continue;
                }

                for (int j = 0; j < 5; j++) {
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
                }
                
            }

            for (int i = 0; i < 5; i++) {
                if (n == i) {
                    continue;
                }

                for (int j = 0; j < 5; j++) {
                    dp[s][n][i] = Math.min(dp[s - 1][j][i] + mp[j][n], dp[s][n][i]);
                }
            }

            s++;
        }

        s--;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[s][i][j]);
            }
        }
        System.out.println(min);
    }

}
