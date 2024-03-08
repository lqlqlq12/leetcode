package hot100;

import java.util.Arrays;

/*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？*/
//不同路径
//dfs 容易超时
//动规 dp[i][j]=[0][0]到[i][j]有几种不同的路径
//动态优化,[i][j]的值只与[i-1][j]和[i][j-1]有关,dp可以优化成一维数组
public class UniquePaths {

    int[][] arr;
    int target_x;
    int target_y;

    public int uniquePaths(int m, int n) {
        arr = new int[m][n];
        target_x = m - 1;
        target_y = n - 1;
        return dfs(0, 0);
    }


    public int dfs(int x, int y) {
        if (x == target_x && y == target_y) {
            return arr[x][y] = 1;
        }
        int re = 0;
        if (x < target_x) {
            if (arr[x + 1][y] == 0) {
                dfs(x + 1, y);
            }
            re += arr[x + 1][y];
        }
        if (y < target_y) {
            if (arr[x][y + 1] == 0) {
                dfs(x, y + 1);
            }
            re += arr[x][y + 1];
        }
        return arr[x][y] = re;
    }

    public int uniquePaths_1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int dfsRefine(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
