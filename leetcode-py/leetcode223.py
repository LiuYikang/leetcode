class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        if A == C or B == D:
            return (G-E) * (H-F)
        if E == G or F == H:
            return (C-A) * (D-B)
        Xmin = E if E > A else A
        Xmax = C if C < G else G
        Ymin = F if F > B else B
        Ymax = D if D < H else H
        print Xmax, Xmin, Ymax, Ymin
        if Xmax <= Xmin or Ymax <= Ymin:
            return ((G-E)*(H-F)) + ((C-A)*(D-B))
        else:
            return ((G-E)*(H-F)) + ((C-A)*(D-B)) - ((Xmax-Xmin) * (Ymax-Ymin))
