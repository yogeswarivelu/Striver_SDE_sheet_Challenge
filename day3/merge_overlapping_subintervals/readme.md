# 56. Merge Intervals

## Problem Link
https://leetcode.com/problems/merge-intervals/

## Approach
- Sort the intervals based on their starting time.
- Initialize the first interval as the current interval (`start`, `end`).
- Traverse the remaining intervals:
  - If the current interval overlaps with the previous one (`intervals[i][0] <= end`), merge them by updating the end value.
  - Otherwise, add the current merged interval to the result list and start a new interval.
- After the traversal, add the last merged interval to the result.
- Convert the list of merged intervals back to a 2D array and return it.

## Time Complexity
O(n log n)
- Sorting the intervals takes O(n log n).
- Merging intervals takes O(n).

## Space Complexity
O(n)
- Extra space is used to store the merged intervals.

## Language
Java

## Java Solution

```java
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
```