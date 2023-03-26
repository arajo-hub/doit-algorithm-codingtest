package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001_1 {

    public static void main(String[] args) throws IOException {
        // 공백이 없는 N개 숫자의 합을 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split("");

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Integer.parseInt(split[i]);
        }

        System.out.println(answer);
    }

}
