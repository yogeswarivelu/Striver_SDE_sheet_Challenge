# Longest Subarray with Sum K

## Problem Link
https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/

## Approach
- Use the Prefix Sum technique along with a HashMap.
- Maintain a running prefix sum while traversing the array.
- If the prefix sum equals `k`, then the subarray from index `0` to `i` has sum `k`.
- For each index, check if `(prefixSum - k)` exists in the HashMap:
  - If it exists, a subarray with sum `k` is found.
  - Calculate its length and update the maximum length.
- Store the first occurrence of each prefix sum in the HashMap to maximize the subarray length.

## Time Complexity
O(n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Long, Integer> map = new HashMap<>();

        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLen = i + 1;
            }

            long remaining = prefixSum - k;

            if (map.containsKey(remaining)) {
                int len = i - map.get(remaining);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
```