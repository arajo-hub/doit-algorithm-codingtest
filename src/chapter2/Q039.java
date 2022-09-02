package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q039 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[10000001];

        for (int i = 2; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 2; i < Math.sqrt(array.length); i++) {
            if (array[i] == 0) {
                continue;
            }
            for (int k = i + i; k < array.length; k = k + i) {
                array[k] = 0;
            }
        }

        int i = n;
        while (true) {
            if (array[i] != 0) {
                int result = array[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
    }

    private static boolean isPalindrome(int num) {
        char[] temp = String.valueOf(num).toCharArray();
        int start = 0;
        int end = temp.length - 1;
        while (start < end) {
            if (temp[start] != temp[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}