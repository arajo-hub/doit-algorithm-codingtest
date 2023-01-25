package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q071 {

    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        int changeCnt = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = numCnt;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];

        for (int i = leftNodeStartIdx + 1; i <= leftNodeStartIdx + numCnt; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < changeCnt + sumCnt; i++) {
            st = new StringTokenizer(br.readLine());

            long type = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            if (type == 1) {
                changeVal(leftNodeStartIdx + start, end);
            } else if (type == 2) {
                start += leftNodeStartIdx;
                end += leftNodeStartIdx;
                System.out.println(getSum(start, (int) end));
            } else {
                return;
            }
        }

        br.close();

    }

    private static long getSum(int start, int end) {
        long partSum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                partSum += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                partSum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return partSum;
    }

    private static void changeVal(int idx, long val) {
        long diff = val - tree[idx];
        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

}
