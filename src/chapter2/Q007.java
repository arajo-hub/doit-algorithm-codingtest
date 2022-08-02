package chapter2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q007 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] elements = new int[n];

        for (int i = 0; i < n; i++) {
            elements[i] = sc.nextInt();
        }

        Arrays.sort(elements);

        int count = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (elements[start] + elements[end] < m) {
                start++;
            } else if (elements[start] + elements[end] > m) {
                end--;
            } else {
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);

    }

}
