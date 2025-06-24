// File: LC876MiddleOfLinkedList.cpp

#include <iostream>
using namespace std;

class LC876MiddleOfLinkedList {

    // Definition for singly-linked list
    struct ListNode {
        int val;
        ListNode* next;

        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode* next) : val(x), next(next) {}
    };

public:
    // Function to find the middle of the linked list
    ListNode* middleNode(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }

    // Utility function to print the list from given node
    void printList(ListNode* head) {
        while (head != nullptr) {
            cout << head->val;
            if (head->next != nullptr) cout << " -> ";
            head = head->next;
        }
        cout << endl;
    }

    // Sample test
    void run() {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode* head = new ListNode(1,
                            new ListNode(2,
                            new ListNode(3,
                            new ListNode(4,
                            new ListNode(5)))));

        cout << "Middle Node and onwards: ";
        printList(middleNode(head)); // Expected: 3 -> 4 -> 5
    }
};

// Entry point
int main() {
    LC876MiddleOfLinkedList solution;
    solution.run();
    return 0;
}
