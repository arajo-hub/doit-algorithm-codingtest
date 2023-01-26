package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q072 {

    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = n;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        for (int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start = start + leftNodeStartIdx;
            end = end + leftNodeStartIdx;

            System.out.println(getMin(start, end));
        }

        br.close();

    }

    private static long getMin(int start, int end) {
        long min = Long.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                min = Math.min(min, tree[start]);
                start++;
            }
            start /= 2;
            if (end % 2 == 0) {
                min = Math.min(min, tree[end]);
                end--;
            }
            end /= 2;
        }
        return min;
    }

    private static void setTree(int i) {
        while (i != 1) {
            if (tree[i / 2] > tree[i]) {
                tree[i / 2] = tree[i];
            }
            i--;
        }
    }

}
