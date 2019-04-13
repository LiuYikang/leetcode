class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) {
            return 0;
        }
        int start = 0, sigh = 1;
        char firstChar = str.charAt(0);
        long res = 0;
        if(firstChar == '+') {
            sigh = 1;
            start++;
        } else if (firstChar == '-') {
            sigh = -1;
            start++;
        }
        while (start < str.length()) {
            if (!Character.isDigit(str.charAt(start))) {
                break;
            }
            res = res * 10 + str.charAt(start) - '0';
            start++;
            if (sigh == 1 && sigh * res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sigh == -1 && sigh * res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        
        return (int)res * sigh;
    }
}