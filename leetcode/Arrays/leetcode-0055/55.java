class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach >= nums.length - 1) {
                return true;
            } else if (reach < i) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return false;
    }
}