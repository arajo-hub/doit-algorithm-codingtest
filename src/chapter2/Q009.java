package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q009 {

    private static int checkValid[];
    private static int eachCount[];
    private static int checkCharCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] dna = new char[s];
        checkValid = new int[4];
        eachCount = new int[4];
        checkCharCount = 0;

        dna = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());

        // 기준이 될 개수를 입력받는다.
        for (int i = 0; i < 4; i++) {
            checkValid[i] = Integer.parseInt(st.nextToken());
            if (checkValid[i] == 0) {
                checkCharCount++;
            }
        }

        // 각각 알파벳마다 확인해서 개수를 올려준다.
        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }

        // 유효한 비밀번호라면 result += 1
        if (checkCharCount == 4) {
            result++;
        }

        // 슬라이딩 윈도우
        // 인덱스 값 초기는 부분 문자열 길이로 시작. j가 앞, i가 뒤.
        for (int i = p; i < s; i++) {
            int j = i - p;
            add(dna[i]); // 뒤를 추가하고
            remove(dna[j]); // 앞을 뺀다.
            if (checkCharCount == 4) {
                result++;
            }
        }

        System.out.println(result);
        bf.close();
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                eachCount[0]++;
                if (eachCount[0] == checkValid[0]) {
                    checkCharCount++;
                }
                break;
            case 'C':
                eachCount[1]++;
                if (eachCount[1] == checkValid[1]) {
                    checkCharCount++;
                }
                break;
            case 'G':
                eachCount[2]++;
                if (eachCount[2] == checkValid[2]) {
                    checkCharCount++;
                }
                break;
            case 'T':
                eachCount[3]++;
                if (eachCount[3] == checkValid[3]) {
                    checkCharCount++;
                }
                break;
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (eachCount[0] == checkValid[0]) {
                    checkCharCount--;
                }
                eachCount[0]--;
                break;
            case 'C':
                if (eachCount[1] == checkValid[1]) {
                    checkCharCount--;
                }
                eachCount[1]--;
                break;
            case 'G':
                if (eachCount[2] == checkValid[2]) {
                    checkCharCount--;
                }
                eachCount[2]--;
                break;
            case 'T':
                if (eachCount[3] == checkValid[3]) {
                    checkCharCount--;
                }
                eachCount[3]--;
                break;
        }
    }

}
