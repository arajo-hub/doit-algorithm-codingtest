package chapter2;

import java.io.IOException;
import java.util.*;

public class Q034 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> positive = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<Integer>();
        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num > 1) {
                positive.offer(num);
            } else if (num < 0) {
                negative.offer(num);
            } else if (num == 1) {
                oneCnt++;
            } else {
                zeroCnt++;
            }
        }

        int sum = 0;
        while (positive.size() > 1) {
            int data1 = positive.poll();
            int data2 = positive.poll();
            sum += data1 * data2;
        }

        if (!positive.isEmpty()) {
            sum += positive.poll();
        }

        while (negative.size() > 1) {
            int data1 = negative.poll();
            int data2 = negative.poll();
            sum += data1 * data2;
        }

        if (!negative.isEmpty()) {
            if (zeroCnt == 0) {
                sum += negative.poll();
            }
        }

        sum += oneCnt;

        System.out.println(sum);

    }

}