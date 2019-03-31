class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }
        }
        if (nums[left] == target) {
            return true;
        }
        if (nums[right] == target) {
            return true;
        }
        return false;
    }
}