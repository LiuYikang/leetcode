class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - end == 1) {
                end = nums[i];
                continue;
            } else {
                String tmp = getStr(start, end);
                res.add(tmp);
                start = nums[i];
                end = nums[i];
            }
        }
        String tmp = getStr(start, end);
        res.add(tmp);
        return res;
    }

    private String getStr(int start, int end) {
        if (start == end) {
            return start + "";
        }
        return start + "->" + end;
    }
}
