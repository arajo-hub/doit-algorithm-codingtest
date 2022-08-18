package chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q027 {

    private static int[] dx = {0, 1, 0, -1};

    private static int[] dy = {1, 0, -1, 0};

    private static int n;

    private static int m;

    private static int[][] maze;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String rowToString = st.nextToken();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(rowToString.substring(j, j + 1));
            }
        }

        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            visited[point.x][point.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];
                if (inMaze(newX, newY) && maze[newX][newY] != 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    maze[newX][newY] = maze[point.x][point.y] + 1;
                    queue.add(new Point(newX, newY));
                }
            }
        }
    }

    private static boolean isEnd(int x, int y) {
        return x == (n - 1) && y == (m - 1);
    }

    private static boolean inMaze(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
