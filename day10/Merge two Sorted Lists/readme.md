# 21. Merge Two Sorted Lists

## Problem Link
https://leetcode.com/problems/merge-two-sorted-lists/

## Approach
- Use recursion to merge the two sorted linked lists.
- Handle the base cases:
  - If `list1` is `null`, return `list2`.
  - If `list2` is `null`, return `list1`.
- Compare the values of the current nodes:
  - If `list1.val <= list2.val`, make `list1` the next node in the merged list and recursively merge `list1.next` with `list2`.
  - Otherwise, make `list2` the next node in the merged list and recursively merge `list1` with `list2.next`.
- Continue until all nodes are merged into a single sorted linked list.

## Time Complexity
O(n + m)

- `n` = number of nodes in `list1`
- `m` = number of nodes in `list2`

## Space Complexity
O(n + m)

- Recursive call stack.

## Language
Java

## Java Solution

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
```