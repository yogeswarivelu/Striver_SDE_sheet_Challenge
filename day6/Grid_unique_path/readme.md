# 62. Unique Paths

## Problem Link
https://leetcode.com/problems/unique-paths/

## Approach
- Use Dynamic Programming to count the number of ways to reach each cell.
- Initialize the first row and first column with `1` because there is only one way to reach those cells.
- For every other cell, the number of unique paths is the sum of:
  - Paths from the cell above.
  - Paths from the cell to the left.
- Fill the DP table row by row.
- The bottom-right cell contains the total number of unique paths.

## Time Complexity
O(m × n)

## Space Complexity
O(m × n)

## Language
Java

## Java Solution

```java
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
```