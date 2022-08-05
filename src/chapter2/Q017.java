package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Q017 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] array = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            array[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            if (array[i] < array[max]) {
                int keep = array[i];
                array[i] = array[max];
                array[max] = keep;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(array[i]);
        }
    }

}
