package chapter2;

import java.util.Scanner;

public class Q003 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        int sumCnt = scan.nextInt();
        int[] sum = new int[cnt + 1];

        for (int i = 1; i <= cnt; i++) {
            int num = scan.nextInt();
            sum[i] += sum[i - 1] + num;
        }

        int[] result = new int[sumCnt];
        for (int j = 0; j < sumCnt; j++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            result[j] = sum[end] - sum[start - 1];
        }

        for (int i : result) {
            System.out.println(i);
        }

    }

}
