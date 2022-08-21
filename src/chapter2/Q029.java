package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q029 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        int m = sc.nextInt();

        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int search = sc.nextInt();

            int start = 0;
            int end = n - 1;
            boolean find = false;
            while (start <= end) {
                int middle = (start + end) / 2;
                if (array[middle] > search) {
                    end = middle - 1;
                } else if (array[middle] < search) {
                    start = middle + 1;
                } else {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

}
