// File: LC92ReverseLinkedListII.java

import java.util.Scanner;

public class LC92ReverseLinkedListII {

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

    // Function to reverse a portion of the list between left and right
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    // Utility to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // Helper to create linked list from array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Example usage with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of linked list
        System.out.print("Enter the number of nodes in the linked list: ");
        int size = scanner.nextInt();
        int[] values = new int[size];

        System.out.println("Enter the values of the linked list:");
        for (int i = 0; i < size; i++) {
            values[i] = scanner.nextInt();
        }

        // Create list from input
        ListNode head = createList(values);

        // Get left and right positions for sublist reversal
        System.out.print("Enter left position: ");
        int left = scanner.nextInt();

        System.out.print("Enter right position: ");
        int right = scanner.nextInt();

        System.out.print("Original List: ");
        printList(head);

        LC92ReverseLinkedListII sol = new LC92ReverseLinkedListII();
        ListNode updatedHead = sol.reverseBetween(head, left, right);

        System.out.print("Reversed Sublist (" + left + " to " + right + "): ");
        printList(updatedHead);

        scanner.close();
    }
}
