/**
516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2

思路：
当已知一个序列是回文时，添加首尾元素后的序列存在两种情况，一种是首尾元素相等，则最长回文的长度加2，当首尾元素不相等，则最长回文序列为仅添加首元素时的最长回文与仅添加尾元素时的最长回文之间的最大值。我们可以用dp[i][j]表示s[i…j]中的最长回文序列，而状态转移方程则是

1. i > j，dp[i][j] = 0；
2. i == j，dp[i][j] = 1；
3. i < j且s[i] == s[j]，dp[i][j] = dp[i + 1][j - 1] + 2；
4. i < j且s[i]！= s[j]，dp[i][j] = max(dp[i + 1][j]，dp[i][j - 1])；

从状态转移方程可以看出，计算dp[i][j]时需要用到dp[i+1][j - 1]和dp[i + 1][j]，所以对于i的遍历应该从尾部开始，最后返回dp[0][s.length() - 1]就行。

**/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i>= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
