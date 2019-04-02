class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0, right = x;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (x / mid >= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right - 1;
    }
}