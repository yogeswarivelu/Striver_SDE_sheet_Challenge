# 21. Merge Two Sorted Lists

## Problem Link
https://leetcode.com/problems/merge-two-sorted-lists/

## Approach
- Use recursion to merge the two sorted linked lists.
- Handle edge cases:
  - If `list1` is null, return `list2`.
  - If `list2` is null, return `list1`.
- Compare the current nodes of both lists:
  - If `list1.val <= list2.val`, attach `list1` to the merged result and recursively merge the remaining nodes.
  - Otherwise, attach `list2` to the merged result and recursively merge the remaining nodes.
- Continue until one of the lists becomes empty.

## Time Complexity
O(n + m)

- `n` = length of `list1`
- `m` = length of `list2`

## Space Complexity
O(n + m)

- Due to the recursive call stack.

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