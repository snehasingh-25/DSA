// File: LC206ReverseLinkedList.java

public class LC206ReverseLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        // Default constructor
        ListNode() {}

        // Constructor with value
        ListNode(int val) {
            this.val = val;
        }

        // Constructor with value and next node
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Function to reverse the linked list
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next; // Save next node
            cur.next = prev;          // Reverse pointer
            prev = cur;               // Move prev forward
            cur = next;               // Move cur forward
        }

        return prev; // New head
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                            new ListNode(2,
                            new ListNode(3,
                            new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original List: ");
        printList(head);

        LC206ReverseLinkedList sol = new LC206ReverseLinkedList();
        ListNode reversedHead = sol.reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}
