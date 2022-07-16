package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Q005 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        long[] sums = new long[n];
        long[] cnts = new long[m];

        long answer = 0;

        sums[0] = scan.nextInt();

        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int reminder  = (int) (sums[i] % m);
            if (reminder == 0) {
                answer++;
            }
            cnts[reminder]++;
        }

        for (int i = 0; i < m; i++) {
            if (cnts[i] > 1) {
                answer = answer + (cnts[i] * (cnts[i] - 1) / 2);
            }
        }

        System.out.println(answer);

    }

}
