/**
303. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
**/
class NumArray {
    List<Integer> sum = new ArrayList<>();
    public NumArray(int[] nums) {
        int tmp = 0;
        sum.add(0);
        for (int i = 0; i < nums.length; i++) {
            tmp += nums[i];
            sum.add(tmp);
        }
    }

    public int sumRange(int i, int j) {
        return sum.get(j + 1) - sum.get(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
