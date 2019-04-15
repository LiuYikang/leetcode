## 214. Shortest Palindrome

Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:
```
Input: "aacecaaa"
Output: "aaacecaaa"
```
Example 2:
```
Input: "abcd"
Output: "dcbabcd"
```

#### solution
该题需要借助kmp算法中求next数组的方法

[从头到尾彻底理解KMP](https://blog.csdn.net/v_july_v/article/details/7041827)