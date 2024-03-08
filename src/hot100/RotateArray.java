package hot100;

//轮转数组
/*给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数*/
/*尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？*/
//注意细节,k可能大于数组长度,k%=nums.length
//方法一：额外一个数组 太蠢
//方法二:
//方法三：将整个数组反转,然后将两部分分别翻转
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int l,int r){
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}
