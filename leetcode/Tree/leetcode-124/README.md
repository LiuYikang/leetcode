## 124. Binary Tree Maximum Path Sum

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
```
Input: [1,2,3]

       1
      / \
     2   3

Output: 6
```
Example 2:
```
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
```

#### solution
1. 递归实现
2. 找到局部最大值来求全局最大值
3. 递归函数的返回要注意不是返回局部最大值
