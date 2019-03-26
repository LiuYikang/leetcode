class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int len = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int bucketCap = (max - min) / len + 1;
        int bucketCnt = (max - min) / bucketCap + 1;
        int[] bucketMax = new int[bucketCnt];
        int[] bucketMin = new int[bucketCnt];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            int idx = (num - min) / bucketCap;
            bucketMax[idx] = Math.max(bucketMax[idx], num);
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            set.add(idx);
        }

        int pre = 0, res = 0;
        while (!set.contains(pre)) {
            pre++;
        }

        for (int i = pre + 1; i < bucketCnt; i++) {
            if (!set.contains(i)) {
                continue;
            }
            res = Math.max(res, bucketMin[i] - bucketMax[pre]);
            pre = i;
        }

        return res;
    }
}