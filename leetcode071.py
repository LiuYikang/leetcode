#Stack
class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        pathList = path.split('/')
        pathStack = []
        for item in pathList:
            if item == '.':
                continue
            elif item == '':
                continue
            elif item == '..':
                if pathStack:
                    pathStack.pop()
                continue
            else:
                pathStack.append(item)
        pl = []
        while pathStack:
            tmp = pathStack.pop()
            pl.append(tmp)
        ans = ""
        for i in range(len(pl)-1, -1, -1):
            ans += "/" + str(pl[i])
        if ans == "":
            ans += '/'
        return ans