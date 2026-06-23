# 18. 4Sum

## Problem Link
https://leetcode.com/problems/4sum/

## Approach
- Sort the array to efficiently handle duplicates and apply the two-pointer technique.
- Fix the first two elements using nested loops (`i` and `j`).
- For the remaining part of the array, use two pointers (`left` and `right`) to find pairs whose sum, together with `nums[i]` and `nums[j]`, equals the target.
- Skip duplicate values for `i`, `j`, `left`, and `right` to avoid duplicate quadruplets.
- Use `long` while calculating the sum to prevent integer overflow.

## Time Complexity
O(n³)

## Space Complexity
O(1)
- Excluding the space required for storing the output.

## Language
Java

## Java Solution

```java
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
```