/**
347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

思路:
使用hashmap+桶排序的思想
注意细节：处理桶排序的冲突
**/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(key);
        }

        List<Integer> res = new ArrayList<>();
        int n = 0;
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
