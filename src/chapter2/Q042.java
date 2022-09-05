package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q042 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int min = a > b ? b : a;
            int max = a > b ? a : b;
            int modResult = max % min;

            while (modResult != 0) {
                max = min;
                min = modResult;
                modResult = max % min;
            }

            System.out.println(a * b / min);
        }
    }
}