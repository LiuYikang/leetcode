class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col + 1];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            res = Math.max(res, maxRectangle(height));
        }
        return res;
    }

    private int maxRectangle(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int i = 0, res = 0;
        Stack<Integer> s = new Stack<>();
        while (i < height.length) {
            if (s.isEmpty() || height[s.peek()] <= height[i]) {
                s.push(i++);
            } else {
                int tmp = s.pop();
                res = Math.max(res, height[tmp] * (s.isEmpty() ? i : i - s.peek() - 1));
            }
        }
        return res;
    }
}