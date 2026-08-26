package Greedy;
import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int value, weight;
        Item(int v, int w) { value = v; weight = w; }
    }

    public static double getMaxValue(List<Item> items, int W) {
        items.sort((a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));
        double totalValue = 0.0;
        for (Item item : items) {
            if (W >= item.weight) {
                W -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double)W / item.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        List<Item> items = new ArrayList<>();
        System.out.println("Enter value and weight of items:");
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt(), w = sc.nextInt();
            items.add(new Item(v, w));
        }
        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        double result = getMaxValue(items, W);
        System.out.println("Maximum value in knapsack: " + result);
        sc.close();
    }
}

