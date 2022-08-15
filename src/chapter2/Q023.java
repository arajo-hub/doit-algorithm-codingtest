package chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q023 {

    private static ArrayList<Integer>[] array;

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new ArrayList[n + 1];

        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            array[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        for (int i : array[v]) {
            if (visited[i] == false) {
                dfs(i);
            }
        }
    }

}
