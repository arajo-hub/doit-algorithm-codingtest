package chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node root = new Node();

        while (n > 0) {
            String text = br.readLine();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char chars = text.charAt(i);

                if (now.next[chars - 'a'] == null) {
                    now.next[chars - 'a'] = new Node();
                }
                now = now.next[chars - 'a'];
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            n--;
        }

        int count = 0;
        while (m > 0) {
            String text = br.readLine();
            Node now = root;
            for (int i = 0; i < text.length(); i++) {
                char chars = text.charAt(i);

                if (now.next[chars - 'a'] == null) {
                    break;
                }

                now = now.next[chars - 'a'];
                if (i == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }
            m--;
        }
        System.out.println(count);
    }

    static class Node {

        Node[] next = new Node[26];
        boolean isEnd;

    }

}
