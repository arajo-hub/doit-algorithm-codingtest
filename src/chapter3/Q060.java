package chapter3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q060 {

    private static int cityCnt;
    private static int start;
    private static int end;
    private static int transportationCnt;
    private static long[] earning;
    private static long[] cost;
    private static ArrayList<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        cityCnt = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(st.nextToken());

        end = Integer.parseInt(st.nextToken());

        transportationCnt = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();

        for (int i = 0; i < transportationCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes.add(new Node(start, end, cost));
        }

        earning = new long[cityCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < earning.length; i++) {
            earning[i] = Integer.parseInt(st.nextToken());
        }

        cost = new long[cityCnt];

        Arrays.fill(cost, Integer.MAX_VALUE);

        String answer;
        if (bellmanFord(0)) {
            answer = "Gee";
        } else {
            if (cost[end] == Integer.MAX_VALUE) {
                answer = "gg";
            } else {
                answer = cost[end] + "";
            }
        }

        System.out.println(answer);

        br.close();

    }

    public static boolean bellmanFord(int start) {
        boolean cycle = false;
        cost[start] = 0;

        for (int i = 0; i < cityCnt; i++) {
            for (int j = 0; j < cityCnt; j++) {
                Node node = nodes.get(j);
                if (cost[node.start] != Integer.MAX_VALUE && cost[node.start] + node.cost  < cost[node.end]) {
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
