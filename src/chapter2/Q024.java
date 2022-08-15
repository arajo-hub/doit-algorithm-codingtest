package chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q024 {

    private static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int numberOfDigits) {
        if (numberOfDigits == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, numberOfDigits + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
