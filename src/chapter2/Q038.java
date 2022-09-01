package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q038 {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();

        long max = sc.nextLong();

        long[] array = new long[10000001];

        for (int i = 2; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(array.length); i++) {
            if (array[i] == 0) {
                continue;
            }

            for (int j = i + i; j < array.length; j = j + i) {
                array[j] = 0;
            }
        }

        int cnt = 0;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != 0) {
                long temp = array[i];
                while ((double) array[i] <= (double)max / (double)temp) {
                    if ((double) array[i] >= (double)min / (double)temp) {
                        cnt++;
                    }
                    temp *= array[i];
                }

            }
        }

        System.out.println(cnt);
    }
}