package _201_400;

//309.买卖的股票的最佳时机含冷冻期
/*给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 .

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。*/
//动规 自己想的 贼棒
//动规:每天有三种选择 买、卖、不动 总共有买1 卖1 不动剩1 不动剩0 四个状态
//分别用a b c d 表示 a2=d1-prices[i] b2=Math.max(a1,c1)+prices[i] c2=Math.max(c2,a1) d2=Math.max(d1,b1)
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int a = -prices[0], b = 0, c = Integer.MIN_VALUE, d = 0;
        for (int i = 1; i < len; i++) {
            int a2 = d - prices[i];
            int b2 = Math.max(a, c) + prices[i];
            int c2 = Math.max(c, a);
            int d2 = Math.max(d, b);
            a = a2;
            b = b2;
            c = c2;
            d = d2;
        }
        return Math.max(b, d);
    }
}
