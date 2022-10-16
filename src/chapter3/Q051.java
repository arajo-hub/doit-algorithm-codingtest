package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q051 {

    private static int[][] array;

    private static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시들의 수

        array = new int[n + 1][n + 1];
        plan = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j < m + 1; j++) {
            plan[j] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(1, 2));

    }

    private static String dfs(int start, int end) {
        if (end == plan.length - 1) {
            return "YES";
        } else {
            if (array[start][end] == 1) { // 연결되어 있음
                dfs(plan[end], plan[end + 1]);
            } else {
                return "NO";
            }
        }
        return "YES";
    }

}
