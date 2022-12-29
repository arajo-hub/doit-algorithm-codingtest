package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Q058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCnt = Integer.parseInt(st.nextToken());

        int roadCnt = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[cityCnt + 1];

        for (int i = 1; i <= cityCnt; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roadCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        PriorityQueue<Integer>[] cost = new PriorityQueue[cityCnt + 1];

        for (int i = 0 ; i <= cityCnt; ++i) {
            cost[i] = new PriorityQueue<>(k);
        }

        int startCity = 1;
        queue.add(new Node(startCity, 0));
        cost[startCity].add(0);

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 시작노드와 연결된 노드 꺼내기
            for (Node node : graph[now.end]) {
                if (cost[node.end].size() < k) { // k개보다 원소 개수가 적을 때
                    cost[node.end].add((now.cost + node.cost) * -1); // (k개를 채울 때까지) 우선순위 큐에 내림차순으로(* -1) 추가
                    queue.add(new Node(node.end, now.cost + node.cost));
                } else if ((cost[node.end].peek() * -1) > now.cost + node.cost) { // k개가 되었을 때, 더 작은 비용을 찾으면
                    cost[node.end].poll(); // 원래 제일 앞에 있던 비용(그전까지는 k번째였던)을 빼고
                    cost[node.end].add((now.cost + node.cost) * -1); // 새로운 더 작은 비용을 넣는다.
                    queue.add(new Node(node.end, now.cost + node.cost));
                }
            }
        }

        for (int i = 1; i <= cityCnt; i++) {
            System.out.println(cost[i].size() == k ? cost[i].peek() * -1 : -1);
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
