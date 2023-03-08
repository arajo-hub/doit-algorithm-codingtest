package chapter3;

import java.io.IOException;
import java.util.Scanner;

public class Q091 {

    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        dp = new long[1001][1001];
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        int m = sc.nextInt();

        long max = 0;

        for (int i = 0; i < n; i++) {
            String mLine = sc.next();
            for (int j = 0; j < m; j++) {
                dp[i][j] = Long.parseLong(String.valueOf(mLine.charAt(j)));
                if (dp[i][j] == 1 && j > 0 && i > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + dp[i][j];
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max * max);

    }

}
