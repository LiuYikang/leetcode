class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        l = len(digits)
        for i in range(l-1, -1, -1):
            digits[i] = (digits[i]+1) % 10
            if digits[i]:
                break
        if digits[0] == 0:
            digits.insert(0, 1)
        return digits
