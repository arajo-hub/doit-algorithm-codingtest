package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q074 {

    private static ArrayList<Integer>[] tree;
    private static int[] depth;
    private static int[] parent;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            tree[start].add(end);
            tree[end].add(start);
        }

        depth = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        bfs(1);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int lca = executeLca(a, b);
            System.out.println(lca);
        }
    }

    private static int executeLca(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int nowSize = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if (count == nowSize) {
                count = 0;
                nowSize = queue.size();
                level++;
            }
        }


    }

}
