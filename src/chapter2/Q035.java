package chapter2;

import java.io.IOException;
import java.util.*;

public class Q035 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Meeting> meetings = new ArrayList<Meeting>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meeting(start, end));
        }

        meetings.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.getEnd() - o2.getEnd() != 0) {
                    return o1.getEnd() - o2.getEnd();
                }
                return o1.getStart() - o2.getStart();
            }
        });

        int answer = 0;
        Meeting previous = new Meeting(0, 0);
        for (Meeting meeting : meetings) {
            if (meeting.getStart() >= previous.getEnd()) {
                answer++;
                previous = meeting;
            }
        }

        System.out.println(answer);

    }

    private static class Meeting {
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int getStart() {
            return this.start;
        }

        private int getEnd() {
            return this.end;
        }

    }

}