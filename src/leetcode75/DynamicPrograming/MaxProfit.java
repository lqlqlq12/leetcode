package leetcode75.DynamicPrograming;

//714.买卖股票的最佳时机含手续费
/*给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费*/
//思路:做了这么多买股票 两个方法 动规、贪心 动规表示每天不同状态所能取得的最大利润 贪心能赚到钱就不卖 要亏了就赶紧转手卖掉
//动规:每天两种状态 有0个股票/有1个股票 分别用a,b表示每一天两种状态的最大利润 对于手续费 可以加到买股票里的成本

public class MaxProfit {
    //dynamic_programing
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int a = 0, b = -prices[0] - fee;
        for (int i = 1; i < len; i++) {
            int t = a;
            a = Math.max(a, b + prices[i]);
            b = Math.max(b, t - prices[i] - fee);
        }
        return a;
    }

    //贪心 不太理解
    public int greed(int[] prices, int fee) {
        int profit = 0, len = prices.length, buy = prices[0] + fee;
        for (int i = 1; i < len; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
