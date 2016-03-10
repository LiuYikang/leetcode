class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        ht = {}
        for item in nums:
            if not ht.has_key(item):
                ht[item] = 0
            ht[item] += 1
            if ht[item] > 1:
                return True
        return False
