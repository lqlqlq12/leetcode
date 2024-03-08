package _201_400;

//329.矩阵中的最长递增路径
/*给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。*/
//dsf 回溯 记忆化搜索 arr[i][j]表示以matrix[i][j]为起点的最长路径 一遍过 秒了
public class LongestIncreasingPath {
    int[][] arr, matrix;
    int m, n, re;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        arr = new int[m][n];
        re = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                re = Math.max(re, backTrack(i, j));
            }
        }
        return re;
    }


    public int backTrack(int i, int j) {
        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        int ans = 0;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            ans = backTrack(i - 1, j);
        }
        if (i < m - 1 && matrix[i][j] < matrix[i + 1][j]) {
            ans = Math.max(ans, backTrack(i + 1, j));
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            ans = Math.max(ans, backTrack(i, j - 1));
        }
        if (j < n - 1 && matrix[i][j] < matrix[i][j + 1]) {
            ans = Math.max(ans, backTrack(i, j + 1));
        }
        return arr[i][j] = ans + 1;
    }

}
