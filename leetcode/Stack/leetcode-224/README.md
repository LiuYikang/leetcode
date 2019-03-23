## 224. Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:
```
Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
```
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

#### Solution
一个栈来辅助计算，用个变量sign来表示当前的符号，我们遍历给定的字符串s，
1. 如果遇到了数字，由于可能是个多位数，所以我们要用while循环把之后的数字都读进来，然后用sign*num来更新结果res；
2. 如果遇到了加号，则sign赋为1，如果遇到了符号，则赋为-1；
3. 如果遇到了左括号，则把当前结果res和符号sign压入栈，res重置为0，sign重置为1；
4. 如果遇到了右括号，结果res乘以栈顶的符号，栈顶元素出栈，结果res加上栈顶的数字，栈顶元素出栈