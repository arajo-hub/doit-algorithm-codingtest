package chapter2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q013 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<Integer>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());

    }

}
