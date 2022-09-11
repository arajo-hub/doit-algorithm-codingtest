package chapter2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long gcd = gcd(a, b);

        if (c % gcd != 0) {
            System.out.println(-1);
        } else {
            int share = (int) (c / gcd);
            long[] rest = execute(a, b);
            System.out.println(rest[0] * share + " " + rest[1] * share);
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    private static long[] execute(long a, long b) {
        long[] rest = new long[2];
        if (b == 0) {
            rest[0] = 1;
            rest[1] = 0;
            return rest;
        }
        long q = a / b;
        long[] v = execute(b, a % b);
        rest[0] = v[1];
        rest[1] = v[0] - v[1] * q;
        return rest;
    }

}