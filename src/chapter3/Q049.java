package chapter3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q049 {

    private static int[] sender = {0, 0, 1, 1, 2, 2};

    private static int[] receiver = {1, 2, 0, 2, 0, 1};

    private static boolean visited[][];

    private static boolean answer[];

    private static int now[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }

        }
    }

    private static void bfs() {
        Queue<WaterBottle> queue = new LinkedList<WaterBottle>();
        queue.add(new WaterBottle(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            WaterBottle waterBottle = queue.poll();
            int a = waterBottle.a;
            int b = waterBottle.b;
            int c = now[2] - a - b;
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new WaterBottle(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    private static class WaterBottle {
        private int a;
        private int b;

        public WaterBottle(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}