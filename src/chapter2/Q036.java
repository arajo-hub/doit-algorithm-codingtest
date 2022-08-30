package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q036 {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String problem = sc.nextLine();

        String[] separated = problem.split("-");

        for (int i = 0; i < separated.length; i++) {
            int temp = groupSum(separated[i]);
            if (i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);
    }

    static int groupSum(String str) {
        int sum = 0;
        String[] temp = str.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }

}