package chapter2;

import java.io.IOException;
import java.util.*;

public class Q028 {

    private static List<Node>[] array;

    private static int[] distance;

    private static boolean[] visited;

    private static int totalCost = 0;

    private static int maxCost = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(); // 노드의 개수

        array = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            array[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < v; i++) {
            int node = sc.nextInt();
            while (true) {
                int edge = sc.nextInt();
                if (edge != -1) {
                    int cost = sc.nextInt();
                    array[node].add(new Node(edge, cost));
                } else {
                    break;
                }
            }
        }
        distance = new int[v + 1];
        visited = new boolean[v + 1];
        bfs(1);
        int max =1;
        for (int i = 2; i <= v; i++) { // 거리값이 제일 큰 포인트 찾기
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[v + 1];
        visited = new boolean[v + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[v]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Node childNode : array[node]) {
                int end = childNode.end;
                int cost = childNode.cost;
                if (!visited[end]) {
                    visited[end] = true;
                    queue.add(end);
                    distance[end] = distance[node] + cost;
                }
            }
        }
    }

    private static class Node {
        private int end;
        private int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

}
