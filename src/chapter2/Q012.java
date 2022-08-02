package chapter2;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Q012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numArray = new int[n];
        int[] result = new int[n];
        String[] strArray = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(strArray[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numArray[stack.peek()] < result[i]) {
                result[stack.pop()] = numArray[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }

}
