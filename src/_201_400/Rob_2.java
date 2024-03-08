package _201_400;

import hot100.MaxArea;

//213.打家劫舍II
/*你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，

这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，

如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。*/
//和打家劫舍I不同的是 房屋从一条 变成了 一圈 还是动规吧
//思路:可以将数组复制一个 叠一起 然后就可以当作1来做了 1 2 3 4 5 6 额 好像不行
//分类讨论 分为偷和不偷第一家 偷:[0:len-2] 不偷:[1:len-1]
//dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
public class Rob_2 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        return Math.max(dynamicProgramming(nums, 0, len - 2), dynamicProgramming(nums, 1, len - 1));
    }

    public int dynamicProgramming(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return nums[start];
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[len - 1];
    }

    public void test() {
        rob(new int[]{2, 3, 2});
    }

    public static void main(String[] args) {
        new Rob_2().test();
    }
}
