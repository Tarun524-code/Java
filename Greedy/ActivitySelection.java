package Greedy;
import java.util.*;

public class ActivitySelection {
    static class Activity {
        int start, end;
        Activity(int s, int e) { start = s; end = e; }
    }

    public static int maxActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.end));
        int count = 1;
        int lastEnd = activities.get(0).end;

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start >= lastEnd) {
                count++;
                lastEnd = activities.get(i).end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();
        List<Activity> activities = new ArrayList<>();
        System.out.println("Enter start and end times:");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(), e = sc.nextInt();
            activities.add(new Activity(s, e));
        }

        int result = maxActivities(activities);
        System.out.println("Maximum activities: " + result);
        sc.close();
    }
}
