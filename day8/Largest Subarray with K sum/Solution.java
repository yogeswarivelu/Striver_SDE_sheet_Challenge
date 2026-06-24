import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Long, Integer> map = new HashMap<>();

        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            long remaining = prefixSum - k;

            if (map.containsKey(remaining)) {
                int len = i - map.get(remaining);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}