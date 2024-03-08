package typical150.DynamicPrograming;

import java.util.Arrays;

//188.买股票的最佳时机IV 只能买卖k次以内
/*给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）*/
//每天的状态:没有,有一个 买0卖0 买1卖1 买[0:k]卖[0:k] and 买1卖0 买2卖1 买[1:k i]卖[0:k-1 i-1]
// empty[i]=Math.max(empty[i-1],remain[i-1]+price[i])
//empty[i]买i卖i remain[i]有一个票 并且买了i次
public class MaxProfit_4 {
    public int maxProfit(int[] prices, int k) {
        int len = prices.length;
        int[] empty = new int[k + 1];
        int[] remain = new int[k + 1];
        Arrays.fill(remain, -prices[0]);
        remain[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                remain[j] = Math.max(remain[j], empty[j - 1] - prices[i]);
                empty[j] = Math.max(empty[j], remain[j] + prices[i]);
            }
        }
        return empty[k];
    }

    public void test() {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices, 1));
    }

    public static void main(String[] args) {
        new MaxProfit_4().test();
    }
}
