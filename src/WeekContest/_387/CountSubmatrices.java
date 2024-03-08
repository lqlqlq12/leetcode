package WeekContest._387;

//100237.元素和小于等于 k 的子矩阵的数目
/*给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。

返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵 的数目。*/
//一眼动规 dp[i][j]表示[0-i][0-j]的子矩阵的和
public class CountSubmatrices {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, re = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + grid[i - 1][j - 1];
                if (dp[i][j] <= k) re++;
            }
        }
        return re;
    }
}
