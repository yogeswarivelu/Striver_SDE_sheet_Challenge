# Count Inversions

## Problem Link
https://takeuforward.org/data-structure/count-inversions-in-an-array/

## Approach
- Use the Merge Sort algorithm to divide the array into smaller subarrays.
- While merging two sorted halves, count inversions:
  - If `nums[left] <= nums[right]`, no inversion exists.
  - Otherwise, `nums[left] > nums[right]`, which means all elements from `left` to `mid` form inversions with `nums[right]`.
- Add `(mid - left + 1)` to the inversion count.
- Continue merging until the entire array is sorted.
- The accumulated count gives the total number of inversions in the array.

## Time Complexity
O(n log n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
class Solution {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }

        return count;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
                count += (mid - left + 1);
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

        return count;
    }
}
```