class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (right - left) / 2 + left;
            while (right > mid && nums[mid] == nums[right]) {
                right--;
            }
            if (mid == right) {
                continue;
            }
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] > nums[right] ? nums[right] : nums[left];
    }
}