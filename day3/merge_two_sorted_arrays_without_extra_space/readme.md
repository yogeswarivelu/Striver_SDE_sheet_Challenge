# 88. Merge Sorted Array

## Problem Link
https://leetcode.com/problems/merge-sorted-array/

## Approach
- Use three pointers starting from the end of the arrays:
  - `i` points to the last valid element in `nums1`.
  - `j` points to the last element in `nums2`.
  - `k` points to the last position in `nums1`.
- Compare elements from the end of both arrays and place the larger element at position `k`.
- Move the corresponding pointer backward after each placement.
- If any elements remain in `nums2`, copy them into `nums1`.
- Since we fill from the back, no extra space is required.

## Time Complexity
O(m + n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
```