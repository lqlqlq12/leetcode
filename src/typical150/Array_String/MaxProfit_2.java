package typical150.Array_String;

//122.买卖股票的最佳时机II
/*给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

返回 你能获得的 最大 利润 。*/
//买过很多此股票了 应该动规
//思路:每天有两种状态 1.有一个股票 2.没有股票 用a表示有一个股票,b没有的最大利润 第i天a,b
// 第i+1天:a'=Math.max(a,b-price[i+1]) b'=Math.max(b,a+price[i+1])
//动规优化为1维的
//贪心 只要是赚钱就继续 要亏钱了就卖了
public class MaxProfit_2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] a = new int[len];
        int[] b = new int[len];
        a[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            a[i] = Math.max(a[i - 1], b[i] - prices[i]);
            b[i] = Math.max(b[i - 1], a[i - 1] + prices[i]);
        }
        return Math.max(a[len - 1], b[len - 1]);
    }

    public int optimize(int[] prices) {
        int len = prices.length;
        int a = -prices[0], b = 0;
        for (int i = 1; i < len; i++) {
            a = Math.max(a, b - prices[i]);
            b = Math.max(b, a + prices[i]);
        }
        return Math.max(a, b);
    }

    public int greed(int[] prices) {
        int len = prices.length, re = 0;
        for (int i = 0; i < len - 1; i++) {
            int now = prices[i], tomorrow = prices[i + 1];
            if (now < tomorrow) {
                re += (tomorrow - now);
            }
        }
        return re;
    }
}
