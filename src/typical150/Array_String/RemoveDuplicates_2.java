package typical150.Array_String;

//删除有序数组中的重复项II
/*给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。*/
//一次遍历 O(n)
//官方巧解,维护一个区间,[0:slow-1] 当要把数放到nums[slow]时,若和nums[slow-2]相等则意味着已有两次重复,所以不放入
public class RemoveDuplicates_2 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0, right;
        for (right = 0; right < len - 2; ) {
            if(nums[right]!=nums[right+1]||nums[right]!=nums[right+2]){
                nums[left++]=nums[right++];
            }
            else{
                nums[left++]=nums[right++];
                nums[left++]=nums[right++];
                while(right<len&&nums[left-1]==nums[right]){
                    right++;
                }
            }
        }
        while (right < len) {
            nums[left++] = nums[right++];
        }
        return left;
    }

    public int func(int[] nums){
        int len=nums.length;
        if(len<3){
            return len;
        }
        int slow=2,fast=2;
        while(fast<len){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
