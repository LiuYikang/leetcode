class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + plus;
            plus = digits[i] / 10;
            digits[i] %= 10;
        }
        if (plus > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = plus;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            digits = newDigits;
        }
        return digits;
    }
}