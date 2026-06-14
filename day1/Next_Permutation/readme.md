# 31. Next Permutation

## Problem Link
https://leetcode.com/problems/next-permutation/

## Approach
- Traverse the array from right to left and find the first index where the current element is smaller than the next element. This is the breakpoint.
- If no such index exists, the array is in descending order, so reverse the entire array to obtain the smallest permutation.
- Otherwise, traverse from the end of the array and find the first element greater than the breakpoint element.
- Swap these two elements.
- Reverse the subarray to the right of the breakpoint to get the next lexicographically greater permutation.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public void nextPermutation(int[] a) {
        int n = a.length;
        int index = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(a[i] < a[i + 1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            reverse(a, 0, n - 1);
            return;
        }

        for(int i = n - 1; i >= index; i--) {
            if(a[i] > a[index]) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                break;
            }
        }

        reverse(a, index + 1, n - 1);
    }

    private void reverse(int[] a, int left, int right) {
        while(left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
}
```