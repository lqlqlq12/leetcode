package typical150.DynamicPrograming;

//198.打家劫舍
/*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。*/
//思路:动态规划 dp[i]要偷i时最多能偷多少 dp[i]=Math.max(dp[i-2],dp[i-3])+nums[i]
//优化:初始化略微复杂 官解:dp[i] [0:i]中最多能偷多少 dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int re = dp[0];
        if (len == 1) {
            return dp[0];
        }
        dp[1] = nums[1];
        re = Math.max(re, dp[1]);
        if (len == 2) {
            return re;
        }
        dp[2] = dp[0] + nums[2];
        re = Math.max(re, dp[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            re = Math.max(re, dp[i]);
        }
        return re;
    }

    public int optimize(int[] nums) {
        int len = nums.length, re = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (len == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        re = Math.max(re, dp[1]);
        if (len == 2) {
            return re;
        }
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            re = Math.max(re, dp[i]);
        }
        return re;
    }
}
