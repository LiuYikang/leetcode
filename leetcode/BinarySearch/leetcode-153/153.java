class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}