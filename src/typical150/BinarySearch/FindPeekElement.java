package typical150.BinarySearch;

//寻找峰值
/*峰值元素是指其值严格大于左右相邻值的元素。

给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
对于所有有效的 i 都有 nums[i] != nums[i + 1]*/
//第一个想法就是从左到右遍历,但要求O(logn)看来要用二分
//人往高处走,水往低处流,只要往高走,就一定可以遇到峰值,因此每次可以排除掉一半
public class FindPeekElement {
    public int findPekElement(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}
