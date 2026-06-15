# 53. Maximum Subarray

## Problem Link
https://leetcode.com/problems/maximum-subarray/

## Approach
- Use Kadane's Algorithm to find the maximum sum subarray in a single traversal.
- Maintain a running sum (`currentSum`) and add each element to it.
- Update the maximum sum (`maxSum`) whenever a larger sum is found.
- If the running sum becomes negative, reset it to `0` since a negative sum cannot contribute to a larger subarray in the future.
- The final value of `maxSum` represents the maximum subarray sum.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maxSum = nums[0];

        for(int num : nums) {

            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);

            if(currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
```