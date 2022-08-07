package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q019 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        quickSort(array, 0, n - 1, k - 1);
        System.out.println(array[k - 1]);
    }

    private static void quickSort(int[] array, int s, int e, int k) {
        if (s < e) {
            int pivot = partition(array, s, e);
            if (pivot == k) {
                return;
            } else if (k < pivot) {
                quickSort(array, s, pivot - 1, k);
            } else {
                quickSort(array, pivot + 1, e, k);
            }
        }
    }

    private static int partition(int[] array, int s, int e) {
        int m = (s + e) / 2;
        swap(array, s, m);
        int pivot = array[s];
        int i = s;
        int j = e;
        while (i < j) {
            while (pivot < array[j]) {
                j--;
            }
            while (i < j && pivot >= array[i]) {
                i++;
            }
            swap(array, i, j);
        }

        array[s] = array[j];
        array[i] = pivot;
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
