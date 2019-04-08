## 32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:
```
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
```
Example 2:
```
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
```

#### solution
借助栈来求解，需要定义个start变量来记录合法括号串的起始位置，我们遍历字符串，如果遇到左括号，则将当前下标压入栈，如果遇到右括号，如果当前栈为空，则将下一个坐标位置记录到start，如果栈不为空，则将栈顶元素取出，此时若栈为空，则更新结果和（i - start + 1）中的较大值，否则更新结果和（i - 栈顶元素）中的较大值