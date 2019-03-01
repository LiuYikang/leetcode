class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        L1 = len(num1)
        L2 = len(num2)
        num3 = [0] * (L1 + L2)
        for i in range(L1):
            for j in range(L2):
                num3[i+j] += int(num1[i]) * int(num2[j])
        L3 = L1 + L2 - 1
        num3 = num3[:L3]
        ret = ''
        carry = 0
        print num3, L3
        for i in range(L3-1, -1, -1):
            ret = str((num3[i]+carry) % 10) + ret
            carry = (num3[i]+carry) / 10
            print ret, carry
        ret = str(carry) + ret
        s = 0
        for i in range(len(ret)):
            if ret[i] != '0' or i == len(ret) - 1:
                s = i
                break
            else:
                continue
        return ret[s:]
