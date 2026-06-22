# 229. Majority Element II

## Problem Link
https://leetcode.com/problems/majority-element-ii/

## Approach
- Iterate through each element in the array.
- Skip the element if it is already present in the result list to avoid duplicate processing.
- Count the frequency of the current element by traversing the entire array.
- If the frequency is greater than `n / 3`, add the element to the result list.
- Return the list containing all elements that appear more than `⌊n/3⌋` times.

## Time Complexity
O(n²)
- For each element, the entire array may be traversed again to count its frequency.

## Space Complexity
O(1)
- Excluding the output list.
- At most two elements can appear more than `n / 3` times.

## Language
Java

## Java Solution

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (ans.contains(nums[i])) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 3) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}
```