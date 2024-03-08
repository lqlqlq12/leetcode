package typical150.Kadane;

//53.最大子数组和
/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。*/
//思路:动规 dp[i]表示以nums[i]结尾的最大子数组和 dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
//因为每一个dp[i]只与nums[i]和上一个dp有关 所以可以把以为dp优化为常数空间(一个变量)
//另一个角度:求出前缀和 然后就变成了买股票
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length, re = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            re = Math.max(re, dp[i]);
        }
        return re;
    }

    public int optimize(int[] nums) {
        int len = nums.length, re = nums[0], dp = nums[0];
        for (int i = 1; i < len; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            re = Math.max(re, dp);
        }
        return re;
    }

    public int method_2(int[] nums) {
        int len = nums.length, re = Integer.MIN_VALUE, min = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            re = Math.max(re, sum - min);
            min = Math.min(min, sum);
        }
        return re;
    }
}
