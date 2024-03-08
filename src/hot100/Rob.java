package hot100;

//打家劫舍
/*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。*/
//一眼动规 dp[i] nums[0:i]中 偷nums[i]的最大金额 dp[i]=max{dp[i-2],dp[i-3]}+nums[i]
//另一种动规 dp[i] nums[0:i]中最多能偷多少 dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if (len > 2) {
            dp[2] = dp[0] + nums[2];
        }
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }
}
