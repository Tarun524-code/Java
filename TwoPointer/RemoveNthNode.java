package TwoPointer;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        for (int i = 0; i <= n; i++) first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        ListNode[] nodes = new ListNode[n];
        for (int i = 0; i < n; i++) nodes[i] = new ListNode(i + 1);
        for (int i = 0; i < n - 1; i++) nodes[i].next = nodes[i + 1];

        System.out.print("Enter position from end to remove: ");
        int pos = sc.nextInt();

        ListNode result = removeNthFromEnd(nodes[0], pos);
        System.out.print("List after removal: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        sc.close();
    }
}

