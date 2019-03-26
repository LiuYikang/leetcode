## 164. Maximum Gap

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:
```
Input: [3,6,9,1]
Output: 3
```
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:
```
Input: [10]
Output: 0
```
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.

#### solution
桶排序的实现

1. 首先找出数组的最大值和最小值，
2. 然后要确定每个桶的容量，即为(最大值 - 最小值) / 个数 + 1，
3. 在确定桶的个数，即为(最大值 - 最小值) / 桶的容量 + 1，
4. 然后需要在每个桶中找出局部最大值和最小值，
5. 而最大间距的两个数不会在同一个桶中，而是一个桶的最小值和另一个桶的最大值之间的间距。