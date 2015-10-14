class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # Ls = len(s)
        # Lp = len(p)
        # if Ls == 0 and Lp == 0:
        #     return True
        # if Ls != 0 and Lp == 0:
        #     return False
        # if Ls == 0 and Lp != 0:
        #     i = 0
        #     while i < Lp:
        #         if p[i] == '*':
        #             i += 1
        #         else:
        #             return False
        #     return True
        # if s[0] == p[0] or p[0] == '?':
        #     return self.isMatch(s[1:], p[1:])
        # if p[0] == '*':
        #     if Ls >= Lp - 1:
        #         return self.isMatch(s[Ls-Lp+1:], p[1:])
        #     else:
        #         return self.isMatch(s, p[1:])
        # return False
        Ls = len(s)
        Lp = len(p)
        pointS = pointP = 0
        lastP = lastS = -1
        while pointS < Ls:
            if pointP < Lp and (s[pointS] == p[pointP] or p[pointP] == '?'):
                pointS += 1
                pointP += 1
            elif pointP < Lp and p[pointP] == '*':
                pointP += 1
                lastS, lastP = pointS, pointP
            elif lastP != -1:
                lastS += 1
                pointS, pointP = lastS, lastP
            else:
                return False
        if pointS == Ls and pointP == Lp:
            return True
        if pointS != Ls and pointP == Lp:
            return False
        if pointS == Ls and pointP != Lp:
            while pointP < Lp:
                if p[pointP] == '*':
                    pointP += 1
                else:
                    return False
            return True
