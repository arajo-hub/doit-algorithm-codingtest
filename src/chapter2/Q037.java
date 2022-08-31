package chapter2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q037 {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int n = sc.nextInt();

        int[] array = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            array[i] = i;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (array[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= n; j = j + i) {
                array[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (array[i] != 0) {
                System.out.println(array[i]);
            }
        }

    }
}