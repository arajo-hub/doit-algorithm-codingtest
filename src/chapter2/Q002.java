package chapter2;

import java.util.Arrays;
import java.util.Scanner;

public class Q002 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        int[] nums = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            nums[i] = scan.nextInt();
        }

        long max = 0;
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            max = (max <= nums[i]) ? nums[i] : max;
            sum += nums[i];
        }

        long result = ((sum * 100) / max) / cnt;

        System.out.println(result);
    }

}
