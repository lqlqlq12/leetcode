package hot100;

import java.util.Arrays;

//最长递增子序列
/*给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列*/
/*你能将算法的时间复杂度降低到 O(n log(n)) 吗?*/
//动规 dp[i]表示以nums[i]结尾的最长递增子序列的长度 O(n^2)
//方法二:贪心+二分查找 让序列上升的尽可能慢
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int[] dp=new int[len];
        int re=1;
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    re=Math.max(re,dp[i]);
                }
            }
        }
        return re;
    }


    public int greedy(int[] nums){
        int len=nums.length;
        //d[i]表示长度为i的递增子序列中所有的可能的结尾的最小值
        int[] d=new int[len+1];
        d[1]=nums[0];
        int curr_len=1;
        for(int i=1;i<len;i++){
            if(nums[i]>d[curr_len]){
                d[++curr_len]=nums[i];
            }
            else if(nums[i]<d[curr_len]){
                //二分查找
                int l=1,r=curr_len;
                while(l<r){
                    int mid=(l+r)>>1;
                    if(nums[i]>d[mid]){
                        l=mid+1;
                    }
                    else if(nums[i]<d[mid]){
                        r=mid;
                    }
                    else{
                        break;
                    }
                }
                if(l==r){
                    d[l]=nums[i];
                }
            }
        }
        return curr_len;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        lengthOfLIS.greedy(new int[]{10,9,2,5,3,7,101,18});
    }
}
