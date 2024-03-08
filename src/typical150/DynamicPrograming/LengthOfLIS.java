package typical150.DynamicPrograming;

import java.util.Arrays;

//300.最长递增子序列
/*给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。*/
//思路:动规把 dp[i]以nums[i]结尾的最长递增子序列的长度 if nums[j]<nums[i] j<i dp[i]=dp[j]+1 O(n^2)
//你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//官解:二分+贪心 贪心:每次尽可能选小的值  d[i]表示长度为i的上升序列中末尾元素的最小值 dp[i]随i递增
//用len表示当前的最长长度 如果nums[i]>dp[len] 那么dp[len+1]=nums[i] len++
//否则 nums[i]<=dp[len] 就要尝试更新dp[i]的值 其中 dp[i-1]<nums[i] and dp[i]>nums[i] 如果有就dp[i]=nums[i]
//用二分查找来找到这个dp[i]
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int re = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    re = Math.max(re, dp[i]);
                }
            }
        }
        return re;
    }

    public int optimize(int[] nums) {
        int len = nums.length, re = 1;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > dp[re]) {
                dp[++re] = nums[i];
            } else if (nums[i] != dp[re]) {
                int left = 1, right = re;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[right] = nums[i];
            }
        }
        return re;
    }
}
