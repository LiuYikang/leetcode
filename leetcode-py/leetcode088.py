class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        for i in range(m):
            nums1[i+n] = nums1[i]
        i, j, k = 0, 0, 0
        while i < m and j < n:
            if nums1[i+n] < nums2[j]:
                nums1[k] = nums1[i+n]
                i += 1
            else:
                nums1[k] = nums2[j]
                j += 1
            k += 1
        while i < m:
            nums1[k] = nums1[i+n]
            i, k = i+1, k+1
        while j < n:
            nums1[k] = nums2[j]
            j, k = j+1, k+1
