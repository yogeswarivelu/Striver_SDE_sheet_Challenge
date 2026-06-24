# Longest Substring Without Repeating Characters

## Problem Link
https://leetcode.com/problems/longest-substring-without-repeating-characters/

## Approach
- Use the Sliding Window technique with a HashMap.
- Maintain two pointers:
  - `left` → Start of the current window.
  - `right` → End of the current window.
- Store each character and its latest index in the HashMap.
- If a character repeats within the current window:
  - Move `left` to one position after the previous occurrence.
- Update the maximum window length during each iteration.
- This ensures every character is processed only once.

## Time Complexity
O(n)

## Space Complexity
O(min(n, m))
- `n` = length of the string
- `m` = size of the character set

## Language
Java

## Java Solution

```java
import java.util.*;

class Solution {

    public int longestNonRepeatingSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
```