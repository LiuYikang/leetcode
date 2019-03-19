/**
 * 239. Sliding Window Maximum

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

Follow up:
Could you solve it in linear time?
 */

/**
 * Solution 1
 * Heap
 * time O(NlogK) space O(K)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[k];
        }
        
        Queue<Integer> pq = new PriorityQueue<>(k, (Comparator<Integer>)(a, b) -> a > b ? -1 : 1);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        List<Integer> res = new ArrayList<>();
        res.add(pq.peek());
        
        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            res.add(pq.peek());
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}

/**
 * Solution 2
 * 双端队列deque实现
 * 用双向队列可以在O(N)时间内解决这题。
 * 当我们遇到新的数时，将新的数和双向队列的末尾比较，如果末尾比新数小，则把末尾扔掉，
 * 直到该队列的末尾比新数大或者队列为空的时候才住手。
 * 这样，我们可以保证队列里的元素是从头到尾降序的，由于队列里只有窗口内的数，
 * 所以他们其实就是窗口内第一大，第二大，第三大...的数。
 * 保持队列里只有窗口内数的方法和上个解法一样，也是每来一个新的把窗口最左边的扔掉，
 * 然后把新的加进去。然而由于我们在加新数的时候，已经把很多没用的数给扔了，
 * 这样队列头部的数并不一定是窗口最左边的数。
 * 这里的技巧是，我们队列中存的是那个数在原数组中的下标，这样我们既可以直到这个数的值，
 * 也可以知道该数是不是窗口最左边的数。
 * 这里为什么时间复杂度是O(N)呢？因为每个数只可能被操作最多两次，
 * 一次是加入队列的时候，一次是因为有别的更大数在后面，所以被扔掉，或者因为出了窗口而被扔掉。
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }     
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);

            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}