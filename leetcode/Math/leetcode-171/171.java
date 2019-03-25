class Solution {
    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }

        int res = 0;
        int mul = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += mul * (s.charAt(i) - 'A' + 1);
            mul *= 26;
        }
        return res;
    }
}