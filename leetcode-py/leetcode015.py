class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def threeSum(self, nums):
        nums.sort()
        ans = []
        for i in range(len(nums)):
            twoPair = self.TwoNums(nums[i+1:], 0-nums[i])
            for pair in twoPair:
                tmp = [nums[i]] + pair
                if tmp not in ans:
                    ans.append(tmp)
        return ans
        
    def TwoNums(self, nums, target):
        ret, pair = [], {}
        for item in nums:
            if item in pair.keys():
                ret.append([target - item, item])
            else:
                pair[target - item] = True
        return ret
