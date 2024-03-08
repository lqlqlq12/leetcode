package typical150.DynamicPrograming;

import java.util.Arrays;

//322.零钱兑换
/*给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。*/
//(错误)贪心 模拟现实 找零钱的时候先用最大的 大错特错 amount=12 coins=[5,4] 可以3个4 但是选了5会找不出来
//官解 动规 dp[i] 最少多少个硬币凑i coins[index]=j dp[i]=dp[i-j]+1
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
