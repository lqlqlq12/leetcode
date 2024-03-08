package typical150.SlideWindow;

//长度最小的子数组
/*给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。*/
//思路:从长度位1开始往上递归,类似于滑动窗口 但这个方法太蠢了
//前缀和+二分查找
//最优解法:用滑动窗口,右指针右移增加和,一旦满足条件,左指针右移压缩窗口 O(n)
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int re = Integer.MAX_VALUE;
        int window_sum = 0;
        int left,right=-1;
        while(right<len-1&&window_sum<target){
            window_sum+=nums[++right];
        }
        if(window_sum<target){
            return 0;
        }
        for(left=-1;;){
            while(window_sum-nums[left+1]>=target){
                window_sum-=nums[++left];
            }
            re=Math.min(re,right-left);
            if(right==len-1){
                return re;
            }
            window_sum+=nums[++right];
        }
    }

    public void test() {
        minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public static void main(String[] args) {
        new MinSubArrayLen().test();
    }
}
