package chapter3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] edge = new int[n + 1]; // 진입차수 관리
        
        int[] time = new int[n + 1]; // 소요시간 관리

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프

        // 그래프 초기화
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        // 입력 잘라서 정리
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            // 입력 종료(-1) 전까지 잘라서 그래프 정리
            while (true) {
                int num = Integer.parseInt(st.nextToken());

                if (num == -1) {
                    break;
                }
                graph.get(num).add(i);

                // 필요한 건물수대로 진입차수 올리기
                edge[i]++;
            }
        }

        // 진입차수 0일 때를 제일 먼저 큐에 넣기
        for (int i = 1; i <= n; i++) {
            if (edge[i] == 0) {
                queue.add(i);
            }
        }

        // 각 건물의 완성시간을 담을 배열
        int[] completeTime = new int[n + 1];

        // 큐에서 꺼내서 그래프통해서 훑기
        while (!queue.isEmpty()) {
            int pollNum = queue.poll();
            for (int next : graph.get(pollNum)) {
                edge[next]--;

                // next를 짓기까지 걸린 시간 계산
                completeTime[next] = Math.max(completeTime[next], completeTime[pollNum] + time[pollNum]);

                if (edge[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(completeTime[i] + time[i]);
        }

    }

}
