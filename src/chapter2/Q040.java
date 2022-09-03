package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q040 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i <= (int) Math.sqrt(max); i++) {
            long pow = i * i;
            long start = min / pow;
            if (min % pow != 0) {
                start++;
            }
            for (long j = start; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}