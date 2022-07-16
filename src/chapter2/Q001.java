package chapter2;

import java.util.Scanner;

public class Q001 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        String nums = scan.next();

        int result = 0;

        for (int i = 0; i < nums.length(); i++) {
            result += Integer.parseInt(String.valueOf(nums.charAt(i)));
        }

        System.out.println(result);
    }

}