## 72. Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
Example 1:
```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```
Example 2:
```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

#### solution
动态规划的实现, dp[i][j]表示word1的前i个字符转换成word2的前j个字符需要的操作次数

分析：
1. 首先是直接插入一个 word2[j]，那么 word2[j] 位置的字符就跳过了，接着比较 word1[i] 和 word2[j+1] 即可。dp[i][j]=dp[i][j-1]+1
2. 第二个种方法是删除，即将 word1[i] 字符直接删掉，接着比较 word1[i+1] 和 word2[j] 即可。dp[i][j]=dp[i-1][j]+1
3. 第三种则是将 word1[i] 修改为 word2[j]，接着比较 word1[i+1] 和 word[j+1] 即可.dp[i][j]=dp[i-1][j-1]+1

dp[i][j] =      /    dp[i - 1][j - 1]     if word1[i - 1] == word2[j - 1]
                \    min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1     else