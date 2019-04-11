## 15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:
```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

#### solution
1. 先对数组进行排序
2. 取第i个位置的元素作为第一个元素，然后在nums[i+1:]中寻找后面两个元素
3. 因为已经排好序，所以可以用两个指针进行查找