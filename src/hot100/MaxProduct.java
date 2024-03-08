package hot100;

/*给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。

子数组 是数组的连续子序列。*/
//乘积最大子数组
//动态规划,但是有负数,维护两个数组,一个最大一个最小
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int length=nums.length;
        int re=nums[0];
        int max=nums[0],min=nums[0];

        for(int i=1;i<length;i++){
            int maxT=max;
            int minT=min;
            max=Math.max(nums[i],Math.max(minT*nums[i],maxT*nums[i]));
            min=Math.min(nums[i],Math.min(minT*nums[i],maxT*nums[i]));
            re=Math.max(re,max);
        }
        return re;
    }
}
