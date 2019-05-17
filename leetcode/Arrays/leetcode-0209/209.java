class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            if (left < right && sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            } else {
                sum += nums[right++];
            }
        }
        while (sum >= s) {
            res = Math.min(res, right - left);
            sum -= nums[left++];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}