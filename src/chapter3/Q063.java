package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q063 {

    public static final int INF = 5000 * 100 - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int userCnt = Integer.parseInt(st.nextToken());

        int relationCnt = Integer.parseInt(st.nextToken());

        int[][] graph = new int[userCnt + 1][userCnt + 1];

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < relationCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());

            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        for (int i = 1; i <= userCnt; i++) { // 거쳐갈 정점 하나
            for (int j = 1; j <= userCnt; j++) {
                for (int k = 1; k <= userCnt; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int[] answer = new int[userCnt + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= userCnt; i++) {
            int sum = 0;
            for (int j = 1; j <= userCnt; j++) {
                sum += graph[i][j];
            }
            answer[i] = sum;
            if (sum < min) {
                min = sum;
            }
        }
        for (int i = 1; i <= userCnt; i++) {
            if (answer[i] == min) {
                System.out.println(i);
                break;
            }
        }


    }

}
