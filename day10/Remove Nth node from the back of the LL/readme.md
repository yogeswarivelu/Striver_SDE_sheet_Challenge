# 19. Remove Nth Node From End of List

## Problem Link
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

## Approach
- Create a dummy node and connect it before the head of the linked list.
- Initialize two pointers, `fast` and `slow`, at the dummy node.
- Move the `fast` pointer `n + 1` steps ahead to maintain a gap of `n` nodes between `fast` and `slow`.
- Move both pointers together until `fast` reaches the end of the list.
- At this point, `slow` points to the node just before the node that needs to be removed.
- Update `slow.next` to skip the target node.
- Return `dummy.next` as the head of the modified linked list.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
```