package Inversion_of_array;
class Solution {
    public long numberOfInversions(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }

        return count;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }

        return count;
    }
}