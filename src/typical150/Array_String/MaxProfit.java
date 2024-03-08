package typical150.Array_String;

//121.买股票的最佳时机
/*给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。*/
//思路:动规 dp[i] 第i天能获得的最大利润 dp[i]=price[i]-min(0:i-1)
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int re = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            re = Math.max(re, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return re;
    }
}
