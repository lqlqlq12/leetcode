package leetcode75.DynamicPrograming;

//746.使用最小花费爬楼梯
/*给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。

你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。

请你计算并返回达到楼梯顶部的最低花费。*/
//动规或贪心
//动规 dp[i]=Max{dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]} dp[0]=dp[1]=0
//贪心 尽量选花费少的 用倒序的贪心 好像不太行
//动规可以优化 dp[i]只和 dp[i-1] dp[i-2]有关
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[len];
    }

//    public int greed(int[] cost) {
//        int len = cost.length, index = len, fee = 0;
//        while (index > 1) {
//            if (cost[index - 2] <= cost[index - 1]) {
//                fee += cost[index - 2];
//                index -= 2;
//            } else {
//                fee += cost[index - 1];
//                index -= 1;
//            }
//        }
//        return fee;
//    }

    //动规可以优化 dp[i]只和 dp[i-1] dp[i-2]有关
    public int optimize(int[] cost) {
        int len = cost.length, a = 0, b = 0, c = 0;
        for (int i = 2; i <= len; i++) {
            c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }
        return b;
    }
}
