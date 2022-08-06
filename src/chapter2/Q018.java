package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q018 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];
        int[] sumArray = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int insertIndex = i;
            int insertValue = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    insertIndex = j + 1;
                    break;
                }
                if (j == 0) {
                    insertIndex = 0;
                }
            }
            for(int j = i; j > insertIndex; j--) {
                array[j] = array[j - 1];
            }
            array[insertIndex] = insertValue;
        }
        sumArray[0] = array[0];
        for (int i = 1; i < n; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + sumArray[i];
        }

        System.out.println(sum);
    }

}
