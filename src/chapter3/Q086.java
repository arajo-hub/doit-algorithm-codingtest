package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q086 {

    private static long[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        d = new long[n + 1];

        d[0] = 0;
        d[1] = 1;

        if (n >= 2) {
            d[2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }

        System.out.println(d[n]);
    }
}
