/**
548.Split Array with Equal Sum
Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.
Example:
Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:
1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].

思路：
三个cuts位置: i, j, k
a (i) b (j) c (k) d 四段
先遍历j可能的位置, 循环中：
再分别遍历i的位置，将sum(a) == sum(b)的可能存在set中，
再遍历k的位置，判断是否有sum(c) == sum(d) 且a、b段也有。
sum计算方式用preSum
Time Complexity: O(N^2)    Space Complexity: O(N)

**/
public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a boolean
     */
    public boolean splitArray(List<Integer> nums) {
        if (nums.size() < 7) {
            return false;
        }
        int[] sums = new int[nums.size()];
        sums[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            sums[i] = sums[i - 1] + nums.get(i);
        }

        for (int j = 3; j < nums.size() - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sums[i - 1] == sums[j - 1] - sums[i]) {
                    set.add(sums[i - 1]);
                }
            }
            for (int k = j + 2; k < nums.size() - 1; k++) {
                int s1 = sums[k - 1] - sums[j];
                int s2 = sums[nums.size() - 1] - sums[k];
                if (s1 == s2 && set.contains(s1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
