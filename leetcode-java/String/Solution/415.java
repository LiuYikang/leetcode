/**
415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
**/
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 && j >= 0) {
            int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + tmp;
            tmp = sum / 10;
            sb.append(sum % 10);
        }

        while (i >= 0) {
            int sum = num1.charAt(i--) - '0' + tmp;
            tmp = sum / 10;
            sb.append(sum % 10);
        }
        while (j >= 0) {
            int sum = num2.charAt(j--) - '0' + tmp;
            tmp = sum / 10;
            sb.append(sum % 10);
        }
        if (tmp > 0) {
            sb.append(tmp);
        }
        return sb.reverse().toString();
    }
}
