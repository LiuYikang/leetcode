class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        s1 = version1.split('.')
        s2 = version2.split('.')
        l1, l2 = len(s1), len(s2)
        l = l1 if l1 < l2 else l2
        for i in range(l):
            if int(s1[i]) > int(s2[i]):
                return 1
            if int(s1[i]) < int(s2[i]):
                return -1
        if l1 > l2:
            j = l2
            while j < l1:
                if int(s1[j]) != 0:
                    return 1
                j += 1
        if l1 < l2:
            j = l1
            while j < l2:
                if int(s2[j]) != 0:
                    return -1
                j += 1
        return 0
