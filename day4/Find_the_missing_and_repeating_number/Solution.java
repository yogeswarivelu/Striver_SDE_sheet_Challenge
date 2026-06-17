package Find_the_missing_and_repeating_number;

import java.util.HashSet;

public class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int repeating = -1;
        int missing = -1;

        for (int num : nums) {
            if (set.contains(num)) {
                repeating = num;
            }
            set.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeating, missing};
    }
} {
    
}
