package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q068 {

    private static int n;
    private static int[] parent;
    private static boolean[] isVisited;
    private static int end;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 노드의 개수

        parent = new int[n];
        isVisited = new boolean[n];

        int root = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < parent.length; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                root = i;
            }
        }

        st = new StringTokenizer(br.readLine());
        end = Integer.parseInt(st.nextToken());

        delete(end);

        answer = 0;
        countLeaf(root);

        System.out.println(answer);
    }

    private static void delete(int deleteNum) {
        parent[deleteNum] = -2;
        for (int i = 0; i < n; i++) {
            if (parent[i] == deleteNum) {
                delete(i);
            }
        }
    }

    private static void countLeaf(int start) {
        boolean isLeaf = true;
        isVisited[start] = true;
        if (parent[start] != -2) {
            for (int i = 0; i < n; i++) {
                if (parent[i] == start && isVisited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) {
                answer++;
            }
        }
    }

}
