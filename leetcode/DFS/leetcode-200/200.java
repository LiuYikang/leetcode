class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] flag = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    count++;
                    dfs(grid, flag, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] flag, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }

        if (flag[row][col]) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        flag[row][col] = true;
        int[][] c = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < 4; i++) {
            dfs(grid, flag, row + c[i][0], col + c[i][1]);
        }
    }
}