class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int p = 0, q = nums.length - 1;
        int i = 0;
        while (i < nums.length) {
            if (i > p && nums[i] == 0) {
                int tmp = nums[p];
                nums[p] = nums[i];
                nums[i] = tmp;
                p++;
            } else if (i < q && nums[i] == 2) {
                int tmp = nums[q];
                nums[q] = nums[i];
                nums[i] = tmp;
                q--;
            } else {
                i++;
            }
        }
        return;
    }
}