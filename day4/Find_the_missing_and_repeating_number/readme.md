# Find Missing and Repeating Numbers

## Problem Link
https://takeuforward.org/arrays/find-the-repeating-and-missing-numbers/

## Approach
- Use a HashSet to track the elements that have already been seen.
- Traverse the array:
  - If an element is already present in the HashSet, it is the repeating number.
  - Otherwise, add it to the HashSet.
- After identifying the repeating number, iterate from `1` to `n`.
- The number that is not present in the HashSet is the missing number.
- Return the repeating and missing numbers as an array.

## Time Complexity
O(n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int repeating = -1;
        int missing = -1;

        for (int num : nums) {
            if (set.contains(num)) {
                repeating = num;
            }
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeating, missing};
    }
}
```