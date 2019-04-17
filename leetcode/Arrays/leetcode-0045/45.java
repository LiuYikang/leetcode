class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int pre = 0, cur = 0;
        int i = 0;
        while (cur < nums.length - 1) {
            res++;
            pre = cur;
            for (; i <= pre; i++) {
                cur = Math.max(cur, i + nums[i]);
            }
            if (pre == cur) {
                return -1;
            }
        }
        return res;
    }
}