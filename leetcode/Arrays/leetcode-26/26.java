class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 1, tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != tmp) {
                nums[start++] = nums[i];
                tmp = nums[i];
            }
        }
        return start;
    }
}