package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q075 {

    private static ArrayList<Integer>[] tree;
    private static int kmax;
    private static int[] depth;
    private static int[][] parent;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        depth = new int[n + 1];
        visited = new boolean[n + 1];
        int temp = 1;
        kmax = 0;

        while (temp <= n) {
            temp <<= 1;
            kmax++;
        }

        parent = new int[kmax + 1][n + 1];

        bfs(1);

        for (int k = 1; k <= kmax; k++) {
            for (int j = 1; j <= n; j++) {
                parent[k][j] = parent[k - 1][parent[k - 1][j]];
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = executeLca(a, b);
            System.out.println(lca);
        }
    }

    private static int executeLca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int k = kmax; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[k][b]]) {
                    b = parent[k][b];
                }
            }
        }
        for (int k = kmax; k >= 0 && a != b; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int lca = a;
        if (a != b) {
            lca = parent[0][lca];
        }
        return lca;
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
                    parent[0][next] = now;
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
