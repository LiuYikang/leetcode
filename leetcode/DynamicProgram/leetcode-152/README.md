## 152. Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
```
Input: [2,3,-2,4]
Output: 6
```
Explanation: [2,3] has the largest product 6.
Example 2:
```
Input: [-2,0,-1]
Output: 0
```
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

#### solution
dp的实现，需要维持当前位置的最大值和最小值

max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));\
min = Math.min(nums[i], Math.min(min * nums[i], tmp * nums[i]));

或者 当nums[i]小于0时，max和min互换，然后再去动态规划求max和min