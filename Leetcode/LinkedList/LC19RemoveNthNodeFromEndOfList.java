// File: LC19RemoveNthNodeFromEndOfList.java

public class LC19RemoveNthNodeFromEndOfList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Function to remove the Nth node from end of list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        int cnt = 0;

        // Move fast pointer n+1 steps ahead
        while (fast != null) {
            if (cnt > n) {
                slow = slow.next;
            }
            fast = fast.next;
            cnt++;
        }

        // Skip the target node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        LC19RemoveNthNodeFromEndOfList sol = new LC19RemoveNthNodeFromEndOfList();

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                            new ListNode(2,
                                new ListNode(3,
                                    new ListNode(4,
                                        new ListNode(5)))));

        System.out.println("Original List:");
        printList(head);

        int n = 2;
        head = sol.removeNthFromEnd(head, n);

        System.out.println("\nList after removing " + n + "th node from end:");
        printList(head);
    }
}
