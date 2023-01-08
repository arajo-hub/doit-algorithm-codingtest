package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q061 {

    public static final int INF = 9900001; // 간선 가중치의 최댓값 * 정점 개수 - 1보다 큰 값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCnt = Integer.parseInt(br.readLine());

        int busCnt = Integer.parseInt(br.readLine());

        int[][] graph = new int[cityCnt + 1][cityCnt + 1];

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                graph[i][j] = INF;
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < busCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start][end] = Math.min(graph[start][end], cost);
        }

        for (int i = 1; i <= cityCnt; i++) { // 거쳐갈 노드 하나 선택
            for (int j = 1; j <= cityCnt; j++) { // 시작
                for (int k = 1; k <= cityCnt; k++) { // 출발
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                if (graph[i][j] == INF) {
                    sb.append(0 + " ");
                    continue;
                }
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
        br.close();

    }

}
