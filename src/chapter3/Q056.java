package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int point = Integer.parseInt(s[0]); // 정점의 개수

        int e = Integer.parseInt(s[1]); // 간선의 개수

        int start = Integer.parseInt(br.readLine());

        List<Node>[] nodeList = new ArrayList[point + 1];

        for (int i = 1; i <= point; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()); // u에서
            int v = Integer.parseInt(st.nextToken()); // v로 가는
            int w = Integer.parseInt(st.nextToken()); // 가중치 w

            nodeList[u].add(new Node(v, w));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] cost = new int [point + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        boolean[] isVisited = new boolean[point + 1];
        queue.add(new Node(start, 0));
        cost[start] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (isVisited[now.end]) {
                continue;
            }

            isVisited[now.end] = true;

            // 시작노드와 연결된 노드 꺼내기
            for (Node node : nodeList[now.end]) {
                if (cost[node.end] > cost[now.end] + node.cost) {
                    cost[node.end] = cost[now.end] + node.cost;
                    queue.add(new Node(node.end, cost[node.end]));
                }
            }
        }

        for (int i = 1; i <= point; i++) {
            System.out.println(cost[i] == Integer.MAX_VALUE ? "INF" : cost[i]);
        }
    }

    static class Node implements Comparable<Node> {

        private int end;
        private int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

}