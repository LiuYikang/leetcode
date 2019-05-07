class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> row = new ArrayList<>(triangle.get(0));
        dp.add(row);
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    tmp.add(dp.get(i - 1).get(0) + triangle.get(i).get(0));
                } else if (j == triangle.get(i).size() - 1) {
                    tmp.add(dp.get(i - 1).get(dp.get(i - 1).size() - 1) + triangle.get(i).get(j));
                } else {
                    tmp.add(triangle.get(i).get(j) + Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                }
            }
            dp.add(tmp);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++) {
            res = Math.min(res, dp.get(dp.size() - 1).get(i));
        }
        return res;
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int[] dp = new int[row];
        for (int i = 0; i < triangle.get(row - 1).size(); i++) {
            dp[i] = triangle.get(row - 1).get(i);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}