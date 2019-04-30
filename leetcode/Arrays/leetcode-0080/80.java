class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 1;
        int p = 1, q = 1;
        while (q < nums.length) {
            if (nums[q] == nums[p - 1]) {
                if (count >= 2) {
                    q++;
                    continue;
                } else {
                    nums[p++] = nums[q++];
                    count++;
                }
            } else {
                count = 1;
                nums[p++] = nums[q++];
            }
        }
        return p;
    }
}