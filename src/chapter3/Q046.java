package chapter3;

import java.io.IOException;
import java.util.*;

public class Q046 {

    private static ArrayList<Integer>[] array;

    private static int[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //도시의 개수
        int m = sc.nextInt(); //도로의 개수
        int k = sc.nextInt(); //거리 정보
        int x = sc.nextInt(); //출발 도시의 번호

        array = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            array[i] = new ArrayList<Integer>();
        }

        visited = new int[n + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            array[start].add(end);
        }

        bfs(x);

        List<Integer> answer = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (visited[i] == k) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int num : answer) {
                System.out.println(num);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(x);
        visited[x]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : array[now]) {
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
    }

}