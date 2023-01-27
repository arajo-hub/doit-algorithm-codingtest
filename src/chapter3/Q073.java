package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q073 {

    private static long[] tree;
    private static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = n;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        Arrays.fill(tree, 1);

        for (int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            if (type == 1) {
                changeVal(leftNodeStartIdx + start, end);
            } else if (type == 2) {
                start += leftNodeStartIdx;
                end += leftNodeStartIdx;
                System.out.println(getMulti(start, (int) end));
            } else {
                return;
            }
        }

        br.close();

    }

    private static long getMulti(int start, int end) {
        long partMulti = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                partMulti = partMulti * tree[start] % mod;
                start++;
            }
            if (end % 2 == 0) {
                partMulti = partMulti * tree[end] % mod;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return partMulti;
    }

    private static void changeVal(int idx, long val) {
        tree[idx] = val;
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] % mod * tree[idx * 2 + 1] % mod;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % mod;
            i--;
        }
    }

}
