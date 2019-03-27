class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<>();

        map.put(n, true);

        while (n != 1) {
            n = help(n);
            if (map.containsKey(n)) {
                return false;
            } else {
                map.put(n, true);
            }
        }
        return true;
    }

    private int help(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            res += digit * digit;
        }
        return res;
    }
}