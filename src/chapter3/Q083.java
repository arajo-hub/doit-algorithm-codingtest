package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q083 {

    private static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생의 수

        long mod = 1000000000;

        long[] d = new long[1000001];

        d[1] = 0;
        d[2] = 1;

        for (int i = 3; i <= n; i++) {
            d[i] = (i - 1) * (d[i - 1] + d[i - 2]) % mod;
        }

        System.out.println(d[n]);
    }
}
