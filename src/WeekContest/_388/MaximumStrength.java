package WeekContest._388;

import org.junit.Test;

//100216.K 个不相交子数组的最大能量值
/*给你一个长度为 n 下标从 0 开始的整数数组 nums 和一个 正奇数 整数 k 。

x 个子数组的能量值定义为 strength = sum[1] * x - sum[2] * (x - 1) + sum[3] * (x - 2) - sum[4] * (x - 3) + ... + sum[x] * 1 ，其中 sum[i] 是第 i 个子数组的和。更正式的，能量值是满足 1 <= i <= x 的所有 i 对应的 (-1)i+1 * sum[i] * (x - i + 1) 之和。

你需要在 nums 中选择 k 个 不相交子数组 ，使得 能量值最大 。

请你返回可以得到的 最大能量值 。

注意，选出来的所有子数组 不 需要覆盖整个数组。*/
//第i个选择子数组之和要尽可能大 第i+1个子数组之和要尽可能小 注意一定要可以选k个子数组 所以要留位置给后面
//使用前缀和 看来思路错了啊
//前缀和 动规
//dp[i][j]表示[0:i-1]内选j个子数组的最大乘积 最终答案为dp[nums.length][k]
//dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+nums[i]*w,dp[i-2][j-1]+nums[i-1,i]*w......,dp[j-1][j-1]+w*nums[j,j+1,..i-1,i])
//第一层j从1开始遍历 第二层i从j开始遍历
//终于做出来了 用了4个小时
public class MaximumStrength {

    public long maximumStrength(int[] nums, int k) {
        int len = nums.length;
        long[][] dp = new long[len + 1][k + 1];
        //j个子数组
        for (int j = 1, flag = 1; j <= k; j++, flag *= -1) {
            int w = (k - j + 1) * flag;
            //i个元素
            dp[j][j] = dp[j - 1][j - 1] + (long) nums[j - 1] * w;
            long t = dp[j][j];
            for (int i = j + 1; i <= len; i++) {
                t = Math.max(t, dp[i - 1][j - 1]) + w * (long) nums[i - 1];
                dp[i][j] = Math.max(dp[i - 1][j], t);
            }
        }
        return dp[len][k];
    }


    @Test
    public void test() {
        System.out.println(maximumStrength(new int[]{-100000000, -10000000, 123, 234}, 3));
    }
}
