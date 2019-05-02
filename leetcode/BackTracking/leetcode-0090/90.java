class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(nums, res, subset, 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> subset, int start) {
        List<Integer> tmp = new ArrayList<>(subset);
        res.add(tmp);

        if (start >= nums.length) {
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}