class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        ans = []
        ans.append(nums[:])
        while self.next_permutation(nums):
            ans.append(nums[:])
        return ans

    def next_permutation(self, nums):
        for i in range(len(nums)-2, -1, -1):
            if nums[i] < nums[i+1]:
                break
        else:
            return False

        for j in range(len(nums)-1, i, -1):
            if nums[j] > nums[i]:
                nums[i], nums[j] = nums[j], nums[i]
                break

        for j in range(0, (len(nums)-i)/2):
            nums[i+1+j], nums[len(nums)-1-j] = nums[len(nums)-1-j], nums[i+1+j]

        return True
