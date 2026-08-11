package TwoPointer;

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        ListNode[] nodes = new ListNode[n];
        for (int i = 0; i < n; i++) nodes[i] = new ListNode(i + 1);
        for (int i = 0; i < n - 1; i++) nodes[i].next = nodes[i + 1];

        System.out.print("Enter position to create cycle (-1 for none): ");
        int pos = sc.nextInt();
        if (pos != -1) nodes[n - 1].next = nodes[pos];

        boolean result = hasCycle(nodes[0]);
        System.out.println("Cycle present: " + result);
        sc.close();
    }
}
