package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q062 {

    public static final int INF = 1 * 99 - 1; // 비용 * (노드 개수 - 1) - 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());

        int[][] graph = new int[nodeCnt][nodeCnt];

        for (int i = 0; i < graph.length; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("0")) {
                    s[j] = INF + "";
                }
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < nodeCnt; i++) { // 거쳐갈 노드 선택
            for (int j = 0; j < nodeCnt; j++) {
                for (int k = 0; k < nodeCnt; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == INF) {
                    graph[i][j] = 0;
                }
                if (graph[i][j] > 0) {
                    graph[i][j] = 1;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
