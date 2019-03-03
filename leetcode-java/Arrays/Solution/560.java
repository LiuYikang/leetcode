/**
560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

解法：
使用map来保存当前数组的求和值，然后每到一个数都将res进行更新。
有点two-sum的思路

建立哈希表的目的是为了让我们可以快速的查找sum-k是否存在，即是否有连续子数组的和为sum-k，如果存在的话，那么和为k的子数组一定也存在，这样当sum刚好为k的时候，那么数组从起始到当前位置的这段子数组的和就是k，满足题意，如果哈希表中事先没有m[0]项的话，这个符合题意的结果就无法累加到结果res中，这就是初始化的用途。
**/
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
