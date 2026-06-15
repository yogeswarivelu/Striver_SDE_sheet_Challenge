# 75. Sort Colors

## Problem Link
https://leetcode.com/problems/sort-colors/

## Approach
- Use the Dutch National Flag Algorithm with three pointers:
  - `i` points to the position where the next `0` should be placed.
  - `j` points to the position where the next `2` should be placed.
  - `k` traverses the array.
- If the current element is `0`, swap it with the element at `i` and move both pointers forward.
- If the current element is `1`, it is already in the correct region, so move `k` forward.
- If the current element is `2`, swap it with the element at `j` and move `j` backward.
- This sorts the array in a single traversal without using extra space.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public void sortColors(int[] a) {
        for(int i = 0, j = a.length - 1, k = 0; k <= j;) {

            if(a[k] == 0) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;
                i++;
                k++;
            }
            else if(a[k] == 1) {
                k++;
            }
            else {
                int t = a[k];
                a[k] = a[j];
                a[j] = t;
                j--;
            }
        }
    }
}
```