package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수

        int m = Integer.parseInt(br.readLine()); // 도로의 개수

        int[] from = new int[n + 1];
        int[] to = new int[n + 1];
        int[] cost = new int[n + 1];

        List<Node>[] froms = new List[n + 1];
        List<Node>[] tos = new List[n + 1];

        // 그래프 초기화
        for (int i = 0; i < n + 1; i++) {
            froms[i] = new ArrayList<Node>();
            tos[i] = new ArrayList<Node>();
        }

        Arrays.fill(cost, Integer.MIN_VALUE);

        // 입력 잘라서 정리
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 출발도시번호 도착도시번호 이 도로를 지나는 데 걸리는 시간
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            froms[start].add(new Node(start, end, time));
            from[end]++;

            tos[end].add(new Node(end, start, time));
            to[start]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        cost[s] = 0;

        List<Integer> orders = new ArrayList<>();

        // 큐에서 꺼내서 그래프통해서 훑기
        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 지점
            orders.add(now);

            for (Node node : froms[now]) {
                int next = node.end;
                cost[next] = Math.max(cost[next], cost[now] + node.time);

                from[next]--;

                if (from[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int count = 0;
        boolean[] isVisited = new boolean[n + 1];
        queue.clear();
        queue.add(e);
        isVisited[e] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 지점
            orders.add(now);

            for (Node node : tos[now]) {
                int next = node.end;
                to[next]--;

                if (cost[now] - node.time == cost[next]) {
                    count++;
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println(cost[e]);
        System.out.println(count);
    }

    static class Node {

        private int start;
        private int end;
        private int time;

        public Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

}
