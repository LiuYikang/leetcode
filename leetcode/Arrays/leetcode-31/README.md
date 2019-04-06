## 31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

#### solution
1. 找到一个最大的索引k，使得nums[k]<nums[k+1]，显然，一旦找到这样的k（k >= 0），说明nums[k+1]>nums[k+2]>nums[n]（其中n+1为容器长度，这里只考虑所有元素都不相同的情况），即这些元素是呈递减排列的。如果找不到这样的k，则说明所有元素都呈递减排列，即字典序达到了最大，将其翻转即可
2. 找到一个最大的索引l，使用nums[k]<nums[l]
3. 交换nums[k]和nums[l]
4. 翻转nums[k]后面所有的元素，即翻转nums[k+1]到nums[n]