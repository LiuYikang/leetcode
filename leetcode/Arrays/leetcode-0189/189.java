class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        help(nums, 0, nums.length - 1);
        help(nums, 0, k - 1);
        help(nums, k, nums.lenght - 1);
    }

    private void help(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }
}