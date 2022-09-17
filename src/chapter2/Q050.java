package chapter2;

import java.io.IOException;
import java.util.Scanner;

public class Q050 {

    private static int[] array;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            array[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int type = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            switch (type) {
                case 0:
                    // 유니언
                    union(a, b);
                    break;
                case 1:
                    // 파인드
                    if (find(a) == find(b)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    break;
            }
        }

    }

    private static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            array[bParent] = aParent;
        }
    }

    private static int find(int num) {
        if (num == array[num]) {
            return num;
        } else {
            array[num] = find(array[num]);
            return array[num];
        }
    }

}