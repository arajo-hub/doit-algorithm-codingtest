package chapter3;

import java.util.Scanner;

public class Q070 {

    private static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nodeCnt = sc.nextInt();
        sc.nextLine();

        tree = new int[26][2];

        for (int i = 0; i < nodeCnt; i++) {
            String[] temp = sc.nextLine().split(" ");

            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            tree[node][0] = (left == '.') ? -1 : left - 'A';
            tree[node][1] = (right == '.') ? -1 : right - 'A';

        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int now) {
        if (now == -1) {
            return;
        }
        System.out.print((char) (now + 'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    private static void inOrder(int now) {
        if (now == -1) {
            return;
        }
        inOrder(tree[now][0]);
        System.out.print((char) (now + 'A'));
        inOrder(tree[now][1]);
    }

    private static void postOrder(int now) {
        if (now == -1) {
            return;
        }
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char) (now + 'A'));
    }

}