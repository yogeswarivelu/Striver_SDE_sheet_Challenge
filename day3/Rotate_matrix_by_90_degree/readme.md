# 48. Rotate Image

## Problem Link
https://leetcode.com/problems/rotate-image/

## Approach
- To rotate the matrix by 90 degrees clockwise in-place, first transpose the matrix.
- During transposition, swap `matrix[i][j]` with `matrix[j][i]` for all `j > i`.
- After transposing, reverse each row of the matrix.
- The combination of transpose + row reversal results in a 90-degree clockwise rotation without using extra space.

## Time Complexity
O(n²)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public void rotate(int[][] a) {
        int n = a.length;

        // Transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // Reverse each row
        for(int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while(left < right) {
                int temp = a[i][left];
                a[i][left] = a[i][right];
                a[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}
```