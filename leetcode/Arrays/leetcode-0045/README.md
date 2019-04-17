## 45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:
```
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
```
Note:

You can assume that you can always reach the last index.

#### solution
Greedy算法
1. 和Jump Game一样，需要维护当前位置最大能到达的距离cur，并且到达当前位置步数为res；
2. 遍历当前位置能到达的cur范围内的所有节点，更新cur的值（cur=max(cur, i+nums[i])；
3. 新的cur值范围内的点，都只需要res+1步数到达；
4. 如果新的cur值不大于旧的cur值，则无法达到最后一个点；
5. 当cur超过最后一个数的时候，返回步数。