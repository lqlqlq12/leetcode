package hot100;

//最大子数组和
/*给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。*/
/*如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解*/
//动规: dp[i] 以nums[i]结尾的最大序列和 dp[i]=max(dp[i-1]+nums[i],nums[i]) O(n) 还可以进一步优化
//将一维数组优化成一个变量
//前缀和 prefix[i]=sum(nums[0:i])
//分治法
public class MaxSubArray {

    //动规
    public int maxSubArray(int[] nums) {
        int len= nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        int re=dp[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            re=Math.max(dp[i],re);
        }
        return re;
    }

    //动规空间优化
    public int DP(int[] nums){
        int len=nums.length;
        int cur=nums[0];
        int re=cur;
        for(int i=1;i<len;i++){
            cur=Math.max(nums[i],cur+nums[i]);
            re=Math.max(re,cur);
        }
        return re;
    }

    //前缀和
    public int prefixSum(int[] nums){
        int len=nums.length;
        int sum=0;
        int min=0;
        int re=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            sum+=nums[i];
            re=Math.max(re,sum-min);
            min=Math.min(min,sum);
        }
        return re;
    }
}
