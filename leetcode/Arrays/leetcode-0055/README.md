## 55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:
```
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```
Example 2:
```
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```

#### solution
Greedy实现
1. 维护一个变量表示能到达的最远距离reach，初始化为0；
2. 遍历array，如果当前坐标大于reach或者reach已经到达最后一个位置，则返回
3. 否则更新reach=max(reach, i+nums[i])，i+nums[i]表示能到达的最大位置