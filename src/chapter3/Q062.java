package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q062 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[nodeCnt][nodeCnt];

        for (int i = 0; i < graph.length; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                graph[i][j] = s[j].equals("1");
            }
        }

        for (int i = 0; i < nodeCnt; i++) { // 거쳐갈 노드 선택
            for (int j = 0; j < nodeCnt; j++) {
                for (int k = 0; k < nodeCnt; k++) {
                    graph[j][k] = graph[j][k] || (graph[j][i] && graph[i][k]);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }

        br.close();
    }

}
