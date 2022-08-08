package chapter2;

import java.io.*;
import java.util.Scanner;

public class Q020 {

    private static int[] array;

    private static int[] keep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        array = new int[n + 1];
        keep = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, n);
        for (int i = 1; i <= n; i++) {
            bw.write(array[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            keep[i] = array[i];
        }
        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if (keep[index1] > keep[index2]) {
                array[k] = keep[index2];
                k++;
                index2++;
            } else {
                array[k] = keep[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            array[k] = keep[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            array[k] = keep[index2];
            k++;
            index2++;
        }
    }

}
