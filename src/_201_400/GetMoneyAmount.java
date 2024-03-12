package _201_400;

import org.junit.Test;

//375.猜数字大小II
/*我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字。
你来猜我选了哪个数字。
如果你猜到正确的数字，就会 赢得游戏 。
如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。*/
//最坏的最难的猜的肯定是中间的中间的中间.... 并且同样是中间 数字更大 需要
//这题不是用二分啊 官解用动规
//dp[i]表示1到i范围内的数字 至少需要dp[i]的钱
//如果只有一个数字 就不要前 两个的话 至少需要小的数字的钱 3个的话 至少需要中间的钱
//i 0
//i,i+1 (i)
//i,i+1,i+2 (i+1)
//i,i+1,i+2,i+3 (i+2)+i=2i+2
//i,i+1,i+2,i+3,i+4 (i+1)+(i+3)=2i+4
//i,i+1,i+2,i+3,i+4,i+5
//官解 dp[i][j]表示[i:j]需要的钱
public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len <= n + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.min(dp[i][j - 1] + j, dp[i + 1][j] + i);
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

    @Test
    public void test() {
        getMoneyAmount(10);
    }
}
