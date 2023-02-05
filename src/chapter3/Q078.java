package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q078 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] apart = new int[14 + 1][14 + 1];

        for (int i = 0; i < apart.length; i++) {
            apart[0][i] = i + 1;
            apart[i][0] = 1;
        }

        for (int i = 1; i < apart.length; i++) {
            for (int j = 1; j < apart.length; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int floor = Integer.parseInt(br.readLine());
            int no = Integer.parseInt(br.readLine());

            System.out.println(apart[floor][no - 1]);
        }
    }

}
