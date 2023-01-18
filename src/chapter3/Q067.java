package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q067 {

    public static ArrayList<Integer> tree[];

    public static boolean[] isVisited;

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());

        tree = new ArrayList[node + 1];

        isVisited = new boolean[node + 1];

        parent = new int[node + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < node - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int start) {
        isVisited[start] = true;
        ArrayList<Integer> nodes = tree[start];
        for (int i = 0; i < nodes.size(); i++) {
            if (!isVisited[nodes.get(i)]) {
                parent[nodes.get(i)] = start;
                dfs(nodes.get(i));
            }
        }
    }

}
