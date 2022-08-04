package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ComparableN[] array = new ComparableN[n];

        for (int i = 0; i < n; i++) {
            array[i] = new ComparableN(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(array);

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < array[i].index - i) {
                max = array[i].index - i;
            }
        }

        System.out.println(max + 1);

    }

    private static class ComparableN implements Comparable<ComparableN> {

        int index;
        int value;

        public ComparableN(int index, int value) {
            super();
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(ComparableN o) {
            return this.value - o.value;
        }
    }

}
