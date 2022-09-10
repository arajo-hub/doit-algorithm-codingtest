package chapter2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Q044 {

    private static List<CNode>[] array;
    private static long lcm; // 최소공배수
    private static boolean[] visited;
    private static long[] d;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();

        array = new ArrayList[n];
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;

        for (int i = 0; i < n; i++) {
            array[i] = new ArrayList<CNode>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            array[a].add(new CNode(b, p, q));
            array[b].add(new CNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }

        d[0] = lcm;
        dfs(0);
        long mgcd = d[0];
        for (int i = 0; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(d[i] / mgcd + " ");
        }

    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (CNode cNode : array[node]) {
            int next = cNode.getB();
            if (!visited[next]) {
                d[next] = d[node] * cNode.getQ() / cNode.getP();
                dfs(next);
            }
        }
    }

    private static class CNode {
        int b;
        int p;
        int q;

        public CNode(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}