package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q066 {

    private static int sum;
    private static PriorityQueue<Edge> queue;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>();

        for (int i = 0; i < computer; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] temp = st.nextToken().toCharArray();
            for (int j = 0; j < computer; j++) {
                int tmp = 0;
                if (temp[j] >= 'a' && temp[j] <= 'z') {
                    tmp = temp[j] - 'a' + 1;
                } else if (temp[j] >= 'A' && temp[j] <= 'Z') {
                    tmp = temp[j] - 'A' + 27;
                }
                sum += tmp;
                if (i != j && tmp != 0) {
                    queue.add(new Edge(i, j, tmp));
                }
            }
        }

        parent = new int[computer];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int usedEdge = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            if (!isCycle(now.start, now.end)) {
                union(now.start, now.end);
                answer+= now.cost;
                usedEdge++;
            }
        }

        if (usedEdge == computer - 1) {
            System.out.println(sum - answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void union(int start, int end) {
        if (find(start) != find(end)) {
            parent[find(end)] = find(start);
        }
    }

    private static boolean isCycle(int start, int end) {
        return find(start) == find(end);
    }

    private static int find(int num) {
        if (parent[num] == num) {
            return num;
        } else {
            return parent[num] = find(parent[num]);
        }
    }

    static class Edge implements Comparable<Edge> {

        private int start;
        private int end;
        private int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}
