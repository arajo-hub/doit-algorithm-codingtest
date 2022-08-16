package chapter2;

import java.util.ArrayList;
import java.util.Scanner;

public class Q025 {

    private static int n;

    private static int m;

    private static boolean[] visited;

    private static ArrayList<Integer>[] array;

    private static int stage = 1;

    private static int endPoint = 5;

    private static boolean isArrived;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n];
        array = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            array[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            array[a].add(b);
            array[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, stage);
            if (isArrived) {
                break;
            }
        }

        System.out.println(isArrived ? 1 : 0);

    }

    private static void dfs(int start, int stage) {
        if (stage == endPoint) {
            isArrived = true;
            return;
        }
        visited[start] = true;
        for (int i : array[start]) {
            if (!visited[i]) {
                dfs(i, stage + 1);
            }
        }
        visited[start] = false;
    }

}
