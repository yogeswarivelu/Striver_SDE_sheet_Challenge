Longest Consecutive Sequence

## Problem Link
https://takeuforward.org/plus/dsa/problems/longest-consecutive-sequence-in-an-array?source=strivers-sde-sheet

## Approach
- Store all elements of the array in a HashSet for O(1) lookups.
- Iterate through each element in the set.
- Consider an element as the start of a sequence only if `num - 1` is not present in the set.
- From the starting element, keep checking for consecutive numbers (`num + 1`, `num + 2`, ...).
- Count the length of the sequence and update the maximum length found.
- This ensures each sequence is processed only once.

## Time Complexity
O(n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}
```