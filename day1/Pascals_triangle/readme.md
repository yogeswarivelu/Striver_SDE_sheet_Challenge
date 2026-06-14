# 118. Pascal's Triangle

## Problem Link
https://leetcode.com/problems/pascals-triangle/

## Approach
- Generate the triangle row by row.
- Every row starts with `1`.
- Use the binomial coefficient formula to compute the remaining elements of the current row:
  
  C(n, r) = C(n, r-1) × (n-r+1) / r

- This avoids calculating factorials and generates each row efficiently.
- Add each generated row to the final result list.

## Time Complexity
O(n²)

## Space Complexity
O(1) Auxiliary Space
(O(n²) space is required for storing the output triangle)

## Language
Java

## Java Solution

```java
class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for(int row = 1; row <= n; row++) {

            List<Integer> rows = new ArrayList<>();
            long ans = 1;

            rows.add(1);

            for(int col = 1; col < row; col++) {
                ans = ans * (row - col);
                ans /= col;

                rows.add((int) ans);
            }

            result.add(rows);
        }

        return result;
    }
}
```