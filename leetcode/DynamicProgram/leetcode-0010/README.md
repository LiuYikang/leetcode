## 10. Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

* '.' Matches any single character.
* '*' Matches zero or more of the preceding element.
* The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.

p could be empty and contains only lowercase letters a-z, and characters like . or *.

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
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```
Example 3:
```
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```
Example 4:
```
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
```
Example 5:
```
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
```

#### solution
dp[i][j]表示s[0:i]与p[0:j]匹配

* if s[i]==p[j]  dp[i][j]=dp[i-1][j-1]
* if p[j]=='.'    dp[i][j]=dp[i-1][j-1]
* if p[j]=='*'
	1. if p[j-1] != s[i] && p[j-1] != '.'   dp[i][j]=dp[i][j-2]   '*'不匹配
	2. if p[j-1] == s[i] || p[j-1]== '.'     
		a. '*'匹配一个，dp[i][j]=dp[i][j-1]
		b. '*'匹配多个，dp[i][j]=dp[i-1][j]
		c. '*'匹配0个，dp[i][j]=dp[i][j-2]
* 对于dp[0][i]，p[i]=='*'的情况需要进行预处理