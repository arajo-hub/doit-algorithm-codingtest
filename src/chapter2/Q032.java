package chapter2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q032 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int price = k;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] <= price) {
                count += price / array[i];
                price = price % array[i];
            }
        }

        System.out.println(count);

    }

}