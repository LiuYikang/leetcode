class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        ht = {}
        t = 0
        for i in xrange(len(nums)):
            t = nums[i]
            if not t in ht or i-ht[t] > k:
                ht[t] = i
            else:
                return True
        return False
