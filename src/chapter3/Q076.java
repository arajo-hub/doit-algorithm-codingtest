package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(combination(n, k));
    }

    private static int combination(int start, int end) {
        if (start == end || end == 0) {
            return 1;
        } else {
            return combination(start - 1, end - 1) + combination(start - 1, end);
        }
    }

}
