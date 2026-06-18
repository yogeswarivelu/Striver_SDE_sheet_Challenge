# 169. Majority Element

## Problem Link
https://leetcode.com/problems/majority-element/

## Approach
- Use a HashMap to store the frequency of each element.
- Traverse the array and update the count of the current element.
- After updating the frequency, check if it exceeds `n / 2`.
- As soon as an element's count becomes greater than `n / 2`, return it.
- Since the problem guarantees that a majority element always exists, the returned element is the answer.

## Time Complexity
O(n)

## Space Complexity
O(n)

## Language
Java

## Java Solution

```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}
```