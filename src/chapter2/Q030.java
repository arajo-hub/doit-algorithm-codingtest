package chapter2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q030 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 레슨 수

        int m = sc.nextInt(); // 블루레이 개수

        int[] array = new int[n];

        int start = 0;

        int end = 0;

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            if (start < array[i]) {
                start = array[i];
            }
            end = end + array[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + array[i] > middle) {
                    cnt++;
                    sum = 0;
                }
                sum = sum + array[i];
            }

            if (sum != 0) {
                cnt++;
            }
            if (cnt > m) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
            System.out.println(start);
        }

    }

}