class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = q;
            q = p + q;
            p = tmp;
        }
        return q;
    }
}