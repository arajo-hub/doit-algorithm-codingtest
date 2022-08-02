package chapter2;

import java.io.*;
import java.util.*;

public class Q011 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numArray = new int[n];

        for (int i = 0; i < n; i++) {
            numArray[i] = sc.nextInt();
        }

        StringBuffer bf = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        boolean result = true;
        int num = 1;

        for (int i = 0; i < numArray.length; i++) {
            int eachNum = numArray[i];
            if (eachNum >= num) {
                while (eachNum >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int popNum = stack.pop();
                if (popNum > eachNum) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if (result) {
            System.out.println(bf.toString());
        }
    }

}
