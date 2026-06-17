# 287. Find the Duplicate Number

## Problem Link
https://leetcode.com/problems/find-the-duplicate-number/

## Approach
- Use a HashSet to keep track of the numbers that have already been seen.
- Traverse the array:
  - If the current number is already present in the HashSet, it is the duplicate number, so return it.
  - Otherwise, add the number to the HashSet.
- Since there is exactly one duplicate number in the array, the first repeated element found is the answer.

## Time Complexity
O(n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}
```