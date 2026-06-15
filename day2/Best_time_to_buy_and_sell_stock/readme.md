# 121. Best Time to Buy and Sell Stock

## Problem Link
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

## Approach
- Maintain the minimum stock price encountered so far.
- For each day, calculate the profit that would be obtained by selling on that day.
- Update the maximum profit if the current profit is greater.
- Update the minimum price whenever a lower stock price is found.
- This ensures a single traversal of the array while keeping track of the best buying and selling opportunity.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Language
Java

## Java Solution

```java
class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {

            int profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);

            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}
```