package typical150.DynamicPrograming;

//221.最大正方形
/*在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。*/
//思路:分治?一个正方形可以分成四个正方形 然后改进的话可以用动规记录面积 dp[i][j] [0:i][0:j]中1的个数
//题解:动规 dp[i][j] 表示以[i][j]为右小角的正方形的最大边长
//好像可以优化成1维的哈
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int re = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            re = Math.max(re, dp[0][i]);
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            re = Math.max(re, dp[i][0]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    re = Math.max(re, dp[i][j]);
                }
            }
        }
        return re * re;
    }

    public int optimize(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        int re = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i] - '0';
            re = Math.max(re, dp[i]);
        }
        for (int i = 1; i < m; i++) {
            int before = dp[0];
            dp[0] = matrix[i][0] - '0';
            re = Math.max(re, dp[0]);
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int t = dp[j];
                    dp[j] = Math.min(before, Math.min(dp[j - 1], dp[j])) + 1;
                    re = Math.max(re, dp[j]);
                    before = t;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return re * re;
    }

    public void test() {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        optimize(matrix);
    }

    public static void main(String[] args) {
        new MaximalSquare().test();
    }

}
