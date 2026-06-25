# 876. Middle of the Linked List

## Problem Link
https://leetcode.com/problems/middle-of-the-linked-list/

## Approach
- Use the Fast and Slow Pointer technique.
- Initialize both `slow` and `fast` pointers at the head of the linked list.
- Move:
  - `slow` by one node at a time.
  - `fast` by two nodes at a time.
- When `fast` reaches the end of the list:
  - `slow` will be at the middle node.
- If the list has an even number of nodes, the second middle node is returned as required by the problem.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```