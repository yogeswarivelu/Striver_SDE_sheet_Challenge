# 50. Pow(x, n)

## Problem Link
https://leetcode.com/problems/powx-n/

## Approach
- Use Java's built-in `Math.pow()` function to calculate `x` raised to the power `n`.
- The function directly returns the result as a `double`.
- This provides a concise solution without manually implementing exponentiation logic.

## Time Complexity
O(log n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public double myPow(double x, int n) {
        double ans = Math.pow(x, n);
        return ans;
    }
}
```