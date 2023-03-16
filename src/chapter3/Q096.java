package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q096 {

    private static int n;

    private static int maxLength;

    private static int[] b = new int[1000001];

    private static int[] a = new int[1000001];

    private static int[] d = new int[1000001];

    private static int[] ans = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int index;
        b[++maxLength] = a[1];
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (b[maxLength] < a[i]) {
                b[++maxLength] = a[i];
                d[i] = maxLength;
            } else {
                index = binarySearch(1, maxLength, a[i]);
                b[index] = a[i];
                d[i] = index;
            }
        }

        System.out.println(maxLength);

        index = maxLength;
        int x = b[maxLength] + 1;
        for (int i = n; i >= 1; i--) {
            if (d[i] == index && a[i] < x) {
                ans[index] = a[i];
                x = a[i];
                index--;
            }
        }

        for (int i = 1; i <= maxLength; i++) {
            System.out.println(ans[i] + " ");
        }
    }

    private static int binarySearch(int l, int r, int now) {
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (b[mid] < now) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
