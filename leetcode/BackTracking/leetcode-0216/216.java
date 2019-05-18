class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        helper(k, n, 1, 0, res, array);
        return res;
    }

    private void helper(int k, int n, int start, int sum, List<List<Integer>> res, List<Integer> array) {
        if (array.size() == k && sum == n) {
            res.add(new ArrayList<Integer>(array));
            return;
        }
        if (array.size() >= k) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            array.add(i);
            helper(k, n, i + 1, sum + i, res, array);
            array.remove(array.size() - 1);
        }
    }
}