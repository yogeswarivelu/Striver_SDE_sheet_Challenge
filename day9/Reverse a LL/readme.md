# 206. Reverse Linked List

## Problem Link
https://leetcode.com/problems/reverse-linked-list/

## Approach
- Use three pointers:
  - `prev` → Points to the previous node.
  - `curr` → Points to the current node.
  - `next` → Temporarily stores the next node.
- Traverse the linked list and reverse the direction of each link.
- Update pointers in each iteration:
  - Store the next node.
  - Reverse the current node's pointer.
  - Move `prev` and `curr` one step forward.
- After the traversal, `prev` points to the new head of the reversed list.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
```