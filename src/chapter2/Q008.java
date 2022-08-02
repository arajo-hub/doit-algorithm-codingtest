package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q008 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        long[] nums = new long[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < n; i++) {
            long criteria = nums[i];
            int start = 0;
            int end = i - 1;

            while (start < end) {
                if ((nums[start] + nums[end]) == criteria) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                } else if ((nums[start] + nums[end]) > criteria) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        System.out.println(count);
        bf.close();
    }

}
