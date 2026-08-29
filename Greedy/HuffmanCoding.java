package Greedy;
import java.util.*;

class HuffmanNode {
    int freq;
    char c;
    HuffmanNode left, right;
    HuffmanNode(int freq, char c) {
        this.freq = freq; this.c = c;
    }
}

public class HuffmanCoding {
    public static void printCodes(HuffmanNode root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.c + ": " + code);
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();
        char[] chars = new char[n];
        int[] freqs = new int[n];
        System.out.println("Enter characters and frequencies:");
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
            freqs[i] = sc.nextInt();
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int i = 0; i < n; i++) pq.add(new HuffmanNode(freqs[i], chars[i]));

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode merged = new HuffmanNode(left.freq + right.freq, '-');
            merged.left = left; merged.right = right;
            pq.add(merged);
        }

        HuffmanNode root = pq.poll();
        System.out.println("Huffman Codes:");
        printCodes(root, "");
        sc.close();
    }
}
