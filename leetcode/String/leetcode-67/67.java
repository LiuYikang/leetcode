class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return "";
        }
        
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int add = 0;
        while (i >= 0 && j >= 0) {
            int sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + add;
            if (sum > 1) {
                add = 1;
                sum %= 2;
            } else {
                add = 0;
            }
            res.insert(0, sum);
        }

        while (i >= 0) {
            int sum = a.charAt(i--) - '0' + add;
            if (sum > 1) {
                add = 1;
                sum %= 2;
            } else {
                add = 0;
            }
            res.insert(0, sum);
        }

        while (j >= 0) {
            int sum = b.charAt(j--) - '0' + add;
            if (sum > 1) {
                add = 1;
                sum %= 2;
            } else {
                add = 0;
            }
            res.insert(0, sum);
        }
        
        if (add > 0) {
            res.insert(0, add);
        }
        return res.toString();
    }
}