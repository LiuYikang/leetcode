/**
718. Maximum Length of Repeated Subarray
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

DP，动态规划。

1. 利用动态规划的思想，首先寻找问题的最优子结构，给出问题的状态转移方程；
2. 利用 dp[i][j] 来存储A[i]和B[j]之前的LCS（最长公共子序列）；
3. 当A[n]=B[m]时，dp[i][j] = dp[i-1][j-1] + 1;max = Math.max(max, dp[i][j])。

**/
class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int alen = A.length;
        int blen = B.length;
        int res = 0;
        int[][] dp = new int[alen + 1][blen + 1];
        for (int i = 1; i <= alen; i++) {
            for (int j = 1; j <= blen; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
}
