# 73.Set Matrix Zeroes

## Problem Link
https://leetcode.com/problems/pascals-triangle/

## Approach
Traverse the matrix and record all rows and columns containing a 0 using two boolean arrays.
In a second traversal, set a cell to 0 if its row or column was marked.
This avoids modifying the matrix while still identifying all original zero positions.

## Time Complexity
O(m × n)

## Space Complexity
O(m + n)

## Language
Java

## Java Solution

```java
class Solution {
    public void setZeroes(int[][] matrix) {

        int m = matrix.length; // row length
        int n = matrix[0].length; // column length


// to mark the rows and cols
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
```