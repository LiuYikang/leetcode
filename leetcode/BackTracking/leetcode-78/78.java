class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        res.add(new ArrayList<Integer>(set));

        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            helper(nums, i, res, set);
        }
        return res;
    }

    public void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> set) {
        if (start >= nums.length) {
            return;
        }

        set.add(nums[start]);
        res.add(new ArrayList<Integer>(set));
        for (int i = start + 1; i < nums.length; i++) {
            helper(nums, i, res, set);
        }
        set.remove(set.size() - 1);
    }
}