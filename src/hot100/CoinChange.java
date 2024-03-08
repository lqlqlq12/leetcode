package hot100;

//零钱兑换

import java.util.Arrays;

/*给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。*/
//一眼动态规划 dp[i] 金额i的最少数目
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        for (int i = 0; i < coins.length; i++) {
            if(amount>=coins[i]){
                dp[coins[i]] = 1;
            }
        }
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
