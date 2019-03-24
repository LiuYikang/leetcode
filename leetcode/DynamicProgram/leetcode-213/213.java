class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int prepre = nums[0];
        int pre = Math.max(nums[0], nums[1]);

        int res = 0;

        for (int i = 2; i < nums.length - 1; i++) {
            int tmp = pre;
            pre = Math.max(prepre + nums[i], pre);
            prepre = tmp;
        }
        res = Math.max(res, pre);

        prepre = nums[1];
        pre = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int tmp = pre;
            pre = Math.max(prepre + nums[i], pre);
            prepre = tmp;
        }
        res = Math.max(res, pre);

        return res;
    }
}