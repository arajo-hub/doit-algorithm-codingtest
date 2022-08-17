package chapter2;

import java.util.*;

public class Q026 {

    private static ArrayList<Integer>[] array;

    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        array = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            array[start].add(end);
            array[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(array[i]);
        }

        visited = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);
    }

    private static void dfs(int start) {
        System.out.print(start + " ");
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (Integer integer : array[start]) {
            if (!visited[integer]) {
                dfs(integer);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (Integer integer : array[now]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }

}
