package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q064 {

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        // 크루스칼 알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); // 정점
        int e = Integer.parseInt(st.nextToken()); // 간선

        ArrayList<Node> graph = new ArrayList<Node>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(start, end, cost));
        }

        Collections.sort(graph);

        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < e; i++) {
            Node node = graph.get(i);
            if (!isCycle(node.start, node.end)) {
                union(node.start, node.end);
                answer += node.cost;
            }
        }

        System.out.println(answer);


    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean isCycle(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int x, int y) {
        if (find(x) != find(y)) {
            parent[find(y)] = find(x);
        }
    }

    static class Node implements Comparable<Node> {

        private int start;
        private int end;
        private int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}
