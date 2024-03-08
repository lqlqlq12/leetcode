package leetcode75.DynamicPrograming;

//198.打家劫舍
/*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，

如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。*/
//动规:dp[i]表示[0:i]能偷窃到的最高金额 dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]}
//dp[0]=nums[0],dp[1]=Math.max(nums[0],nums[1]}
//优化 dp[i]的取值只由dp[i-1]和dp[i-2]来决定 可以把O(n)的空间优化为常数的
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public int optimize(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int a = nums[0], b = Math.max(a, nums[1]);
        for (int i = 2; i < len; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return b;
    }
}
