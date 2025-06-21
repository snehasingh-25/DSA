// File: ReverseLinkedList.java

class ListNode {
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

class Solution {
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
}

// Optional: Test the reverseList method
public class LC206ReverseLinkedList {
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1, 
                            new ListNode(2, 
                            new ListNode(3, 
                            new ListNode(4, 
                            new ListNode(5)))));

        System.out.print("Original List: ");
        printList(head);

        Solution sol = new Solution();
        ListNode reversedHead = sol.reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}
