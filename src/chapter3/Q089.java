package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q089 {

    private static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        int[] l = new int[n];
        l[0] = d[0];
        int result = l[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(d[i], l[i - 1] + d[i]);
            result = Math.max(result, l[i]);
        }

        int[] r = new int[n];
        r[n - 1] = d[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(d[i], r[i + 1] + d[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int temp = l[i - 1] + r[i + 1];
            result = Math.max(result, temp);
        }

        System.out.println(result);
    }
}
