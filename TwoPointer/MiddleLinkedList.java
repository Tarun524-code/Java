package TwoPointer;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MiddleLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        ListNode[] nodes = new ListNode[n];
        for (int i = 0; i < n; i++) nodes[i] = new ListNode(i + 1);
        for (int i = 0; i < n - 1; i++) nodes[i].next = nodes[i + 1];

        ListNode result = middleNode(nodes[0]);
        System.out.println("Middle node value: " + result.val);
        sc.close();
    }
}
