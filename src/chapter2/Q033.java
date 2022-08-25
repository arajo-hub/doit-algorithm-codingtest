package chapter2;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q033 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        int answer = 0;
        while (pq.size() != 1) {
            int data1 = pq.remove();
            int data2 = pq.remove();
            answer += data1 + data2;
            pq.add(data1 + data2);
        }

        System.out.println(answer);

    }

}