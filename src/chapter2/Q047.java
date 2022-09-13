package chapter2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Q047 {

    private static ArrayList<Integer>[] array;

    private static boolean[] visited;

    private static int[] cnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int m = sc.nextInt();

        array = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            array[i] = new ArrayList<Integer>();
        }

        cnt = new int[n + 1];

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            array[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
            visited = new boolean[n + 1];
        }

        int max = Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : array[now]) {
                if (!visited[next]) {
                    cnt[next]++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

}