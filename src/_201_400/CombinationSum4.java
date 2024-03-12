package _201_400;

import java.util.Arrays;

//377.组合总和IV
/*给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。

题目数据保证答案符合 32 位整数范围。*/
//进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = nums[0]; i <= target; i++) {
            for (int j = 0; j < len && nums[j] <= i; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }


}
