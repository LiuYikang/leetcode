class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }
            set.remove(num);
            int pre = num - 1;
            int next = num + 1;
            while (set.contains(pre)) {
                set.remove(pre);
                pre--;
            }
            while (set.contains(next)) {
                set.remove(next);
                next++;
            }
            res = Math.max(res, next - pre - 1);
        }
        return res;
    }
}