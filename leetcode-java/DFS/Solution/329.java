/**
329. Longest Increasing Path in a Matrix

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

**/
class Solution {
    ArrayList<ArrayList<Integer>> path= new ArrayList<ArrayList<Integer>>();
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            path.add(new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                path.get(i).add(0);
            }
        }

        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int len = dfs(matrix, path, i, j);
                path.get(i).set(j, len);
                res = Math.max(res, len);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, ArrayList<ArrayList<Integer>> path, int i, int j) {
        if (path.get(i).get(j) > 0) {
            return path.get(i).get(j);
        }

        int[][] tmp = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int m = i + tmp[k][0];
            int n = j + tmp[k][1];
            if (m < 0 || m >= matrix.length || n < 0 || n >= matrix[m].length) {
                res = Math.max(res, 1);
            } else if (matrix[m][n] > matrix[i][j]) {
                int tmplen = dfs(matrix, path, m, n);
                path.get(m).set(n, tmplen);
                res = Math.max(res, 1 + dfs(matrix, path, m, n));
            } else {
                res = Math.max(res, 1);
            }
        }
        return res;
    }
}
