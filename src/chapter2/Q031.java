package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q031 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        long start = 1;
        long end = k;
        long answer = 0;
        while (start <= end) {
            long middle = (start + end) / 2;
            long nums = 0;
            for (int i = 1; i <= n; i++) {
                nums += Math.min(middle / i, n);
            }
            if (nums >= k) {
                answer = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        System.out.println(answer);

    }

}