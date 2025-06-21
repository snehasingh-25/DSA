// File: MiddleOfLinkedList.cpp

#include <iostream>
using namespace std;

// Definition for singly-linked list
struct ListNode {
    int val;
    ListNode* next;

    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;

        // Move fast by 2 and slow by 1 step
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }
};

// Utility to print linked list from given node
void printList(ListNode* head) {
    while (head != nullptr) {
        cout << head->val;
        if (head->next != nullptr) cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    // Sample list: 1 -> 2 -> 3 -> 4 -> 5
    ListNode* head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5)))));

    Solution sol;
    ListNode* mid = sol.middleNode(head);

    cout << "Middle Node and onwards: ";
    printList(mid);  // Expected output: 3 -> 4 -> 5

    return 0;
}
