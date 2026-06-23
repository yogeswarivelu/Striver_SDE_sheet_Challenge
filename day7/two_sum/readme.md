# 1. Two Sum

## Problem Link
https://leetcode.com/problems/two-sum/

## Approach
- Use two nested loops to check every possible pair of elements in the array.
- For each element, iterate through the remaining elements and calculate their sum.
- If the sum equals the target value, return the indices of the two elements.
- Since the problem guarantees exactly one solution, return the indices as soon as the pair is found.

## Time Complexity
O(n²)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
```