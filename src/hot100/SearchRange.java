package hot100;

/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。*/

import java.util.Arrays;

//在排序数组中查找元素的第一个和最后一个位置
public class SearchRange {

    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=8;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] searchRange(int[] nums, int target) {
        int length=nums.length;
        int left=0,right=length-1;
        int begin=-1,end=-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]==target){
                right=mid-1;
                begin=mid;
            }
            else{
                right=mid-1;
            }
        }
        left=0;
        right=length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]==target){
                left=mid+1;
                end=mid;
            }
            else{
                right=mid-1;
            }
        }
        return new int[]{begin,end};
    }
}
