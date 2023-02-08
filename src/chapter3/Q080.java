package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q080 {

    public static void main(String[] args) throws IOException {
        int[] d = new int[51];
        double[] probability = new double[51];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int t = 0;
        for (int i = 0; i < m; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            t += d[i];
        }

        st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        double ans = 0.0;

        for (int i = 0; i < m; i++) {
            if (d[i] >= k) {
                probability[i] = 1.0;
                for (int j = 0; j < k; j++) {
                    probability[i] *= (double) (d[i] - j) / (t - j);
                }
            }
            ans += probability[i];
        }
        System.out.println(ans);
    }
}
