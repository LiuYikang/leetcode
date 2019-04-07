## 44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

* '?' Matches any single character.
* '*' Matches any sequence of characters (including the empty sequence).
* The matching should cover the entire input string (not partial).

Note:
* s could be empty and contains only lowercase letters a-z.
* p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
```
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```
Example 2:
```
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
```
Example 3:
```
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```
Example 4:
```
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
```
Example 5:
```
Input:
s = "acdcb"
p = "a*c?b"
Output: false
```

#### solution
动态规划实现，dp[i][j] 表示s[0:i]与p[0:j]是否匹配

状态转移方程
           / dp[i-1][j-1]  when s[i-1] == p[j-1] || p[j-1] == '?'
dp[i][j] = - dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j]  when p[j-1] == '*'
           \ false when s[i-1] != p[j-1]

初始化 dp 为false：
1. dp[0][0]=true，
2. dp[0][j] = dp[0][j-1]  when p[j-1] == '*'