package Greedy;
import java.util.*;

public class JobSequencing {
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id; this.deadline = deadline; this.profit = profit;
        }
    }

    public static int maxProfit(List<Job> jobs) {
        jobs.sort((a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job job : jobs) maxDeadline = Math.max(maxDeadline, job.deadline);

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int totalProfit = 0;
        for (Job job : jobs) {
            for (int d = job.deadline; d > 0; d--) {
                if (slot[d] == -1) {
                    slot[d] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        List<Job> jobs = new ArrayList<>();
        System.out.println("Enter job id, deadline, profit:");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt(), deadline = sc.nextInt(), profit = sc.nextInt();
            jobs.add(new Job(id, deadline, profit));
        }

        int result = maxProfit(jobs);
        System.out.println("Maximum profit: " + result);
        sc.close();
    }
}

