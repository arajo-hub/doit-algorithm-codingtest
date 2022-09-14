package chapter2;

import java.io.IOException;
import java.util.*;

public class Q048 {

    private static ArrayList<Integer>[] array;

    private static boolean[] visited;

    private static int[] set;

    private static boolean isEven;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt(); // 테스트케이스의 개수

        for (int i = 0; i < k; i++) {
            int v = sc.nextInt(); // 노드의 개수
            int e = sc.nextInt(); // 에지의 개수

            array = new ArrayList[v + 1];
            for (int j = 0; j < array.length; j++) {
                array[j] = new ArrayList<Integer>();
            }
            visited = new boolean[v + 1];
            set = new int[v + 1];
            isEven = true;

            for (int j = 0; j < e; j++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();

                array[node1].add(node2);
                array[node2].add(node1);
            }

            for (int j = 1; j < v + 1; j++) {
                if (isEven) {
                    dfs(j);
                } else {
                    break;
                }

            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int now : array[node]) {
            if (!visited[now]) {
                set[now] = (set[node] + 1) % 2;
                dfs(now);
            } else if (set[node] == set[now]) {
                isEven = false;
            }
        }
    }

}