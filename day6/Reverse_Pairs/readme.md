# 493. Reverse Pairs

## Problem Link
https://leetcode.com/problems/reverse-pairs/

## Approach
- Use a modified Merge Sort algorithm to count reverse pairs efficiently.
- Divide the array into two halves recursively until each subarray contains a single element.
- Before merging two sorted halves, count the number of reverse pairs:
  - A reverse pair is defined as:
    
    nums[i] > 2 * nums[j]
    
    where `i < j`.
- Since both halves are already sorted, use two pointers to count valid pairs in linear time.
- After counting, merge the two sorted halves.
- Sum up the counts from the left half, right half, and cross pairs to get the final answer.

## Time Complexity
O(n log n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high &&
                    (long) nums[i] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}
```