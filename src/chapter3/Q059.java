package chapter3;

import java.io.*;
import java.util.*;

public class Q059 {

    private static int cityCnt;
    private static int routeCnt;
    private static long[] cost;
    private static ArrayList<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        cityCnt = Integer.parseInt(st.nextToken());

        routeCnt = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();

        for (int i = 0; i < routeCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes.add(new Node(start, end, cost));
        }

        cost = new long[cityCnt + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);

        if (bellmanFord(1)) {
           bw.write(-1 + "\n");
        } else {
            for (int i = 2; i <= cityCnt; i++) {
                if (cost[i] == Integer.MAX_VALUE) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(cost[i] + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean bellmanFord(int start) {
        boolean cycle = false;
        cost[start] = 0;

        for (int i = 0; i <= cityCnt; i++) {
            for (int j = 0; j < routeCnt; j++) {
                Node node = nodes.get(j);
                if (cost[node.start] != Integer.MAX_VALUE && cost[node.start] + node.cost < cost[node.end]) {
                    cost[node.end] = cost[node.start] + node.cost;
                    if (i == cityCnt) {
                        cycle = true;
                    }
                }
            }
        }
        return cycle;
    }

    static class Node {

        private int start;
        private int end;
        private int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

    }

}
