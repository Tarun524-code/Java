package Greedy;
import java.util.*;
public class MeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals) {
            if(!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of meetings: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("Enter meeting intervals (start end):");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int result = minMeetingRooms(intervals);
        System.out.println("Minimum number of meeting rooms required: " + result);
        sc.close();
    }
}