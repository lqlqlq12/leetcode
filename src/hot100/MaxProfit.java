package hot100;

//买股票最佳时机 只能买卖1次
/*给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。*/
//动规 dp[i] 第i天卖出最多能赚多少
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int re = Integer.MIN_VALUE;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            re = Math.max(re, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return re;
    }
}
