package Greedy;
import java.util.*;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;

        int start = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stations: ");
        int n = sc.nextInt();
        int[] gas = new int[n], cost = new int[n];
        System.out.println("Enter gas at each station:");
        for (int i = 0; i < n; i++) gas[i] = sc.nextInt();
        System.out.println("Enter cost to next station:");
        for (int i = 0; i < n; i++) cost[i] = sc.nextInt();

        int result = canCompleteCircuit(gas, cost);
        System.out.println("Starting station index: " + result);
        sc.close();
    }
}

