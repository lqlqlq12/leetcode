package _1_200;

//174.地下城游戏
/*恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。

返回确保骑士能够拯救到公主所需的最低初始健康点数。

注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。*/
//应该是动规 假设骑士只有0的血量 dp[i][j][2]
//dp[i][j][0]表示到达matrix[i][j]时 最多可以有多少血量
//dp[i][j][1]表示要到达matrix[i][j]的各种路径中 遇到的最低血量的最高值
//选择到达matrix[i][j]时根据dp[i-1][j][1]和dp[i][j-1][j]来选择 这个方法不行 没有后效性
//换一个角度 从右上角向左上角遍历dp[i][j]表示至少需要多少血量才能到达公主房间 每次只能往上和往左 dp[i][j]>=1
//dp[i][j]只与dp[i+1][j]和dp[i][j+1]有关 可以优化成一维的
public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] - dungeon[m - 1][i + 1];
            if (dp[m - 1][i] <= 0) dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] - dungeon[i + 1][n - 1];
            if (dp[i][n - 1] <= 0) dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j] - dungeon[i + 1][j], dp[i][j + 1] - dungeon[i][j + 1]);
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        int re = dp[0][0] - dungeon[0][0];
        if (re <= 0) return 1;
        return re;
    }

    public int optimize(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - dungeon[m - 1][i + 1];
            if (dp[i] <= 0) dp[i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] -= dungeon[i + 1][n - 1];
            if (dp[n - 1] <= 0) dp[n - 1] = 1;
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.min(dp[j] - dungeon[i + 1][j], dp[j + 1] - dungeon[i][j + 1]);
                if (dp[j] <= 0) dp[j] = 1;
            }
        }
        int re = dp[0] - dungeon[0][0];
        if (re <= 0) return 1;
        return re;
    }
}
