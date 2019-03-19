/**
239. Sliding Window Maximum

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
**/
func maxSlidingWindow(nums []int, k int) []int {
	res := []int{}
	deque := []int{}
	for i := range nums {
		if len(deque) != 0 && deque[0] == i-k {
			deque = deque[1:]
		}
		j := len(deque) - 1
		for j >= 0 && nums[i] >= nums[deque[j]] {
			j--
		}
		deque = append(deque[:j+1], i)

		if i >= k-1 {
			res = append(res, nums[deque[0]])
		}
	}
	return res
}