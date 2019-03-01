class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        lenA, lenB = len(a), len(b)
        ans = ""
        i, j, carry = lenA-1, lenB-1, 0
        while i >= 0 and j >= 0:
            carry, tmp = divmod(int(a[i])+int(b[j])+carry, 2)
            ans = str(tmp) + ans
            i, j = i-1, j-1
        while i >= 0:
            carry, tmp = divmod(int(a[i])+carry, 2)
            ans = str(tmp) + ans
            i -= 1
        while j >= 0:
            carry, tmp = divmod(int(b[j])+carry, 2)
            ans = str(tmp) + ans
            j -= 1
        if carry > 0:
            ans = str(carry) + ans
        return ans
        