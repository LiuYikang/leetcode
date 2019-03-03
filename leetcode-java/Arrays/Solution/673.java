/**
673. Number of Longest Increasing Subsequence
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.

解法：
dp[i] 表示到i位置的最长子序列长度，ct[i]表示到位置i的最长子序列个数
核心就是不断更新dp[i]，从而得到当前的最优解。
然而，最优解可能不止一个，这种情况会发生在 dp[i] == dp[j]+1，即i与j具有相同的序列长度，那么我们更新当前长度ct[i] = ct[i]+ct[j]
若dp[j]+1>dp[i],则更新最长子序列的个数为dp[j]的个数，和ct[i]个数

**/
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] ct = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ct[i] = 1;
            dp[i] = 1;
        }

        int maxlen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[i] == dp[j] + 1) {
                            ct[i] += ct[j];
                        } else if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            ct[i] = ct[j];
                    }
                }

                maxlen = Math.max(maxlen, dp[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == maxlen) {
                res += ct[i];
            }
        }
        return res;
    }
}
