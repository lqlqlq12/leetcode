package leetcode75.SlideWindow;

//1493.删掉一个元素以后全为1的最长子数组
/*给你一个二进制数组 nums ，你需要从中删掉一个元素。

请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。

如果不存在这样的子数组，请返回 0 。*/
//思路:滑动窗口 窗口可以包含一个0 没有0的窗口,需要长度-1
public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int left = 0, right, re = 0, contain = 0;
        for (right = 0; right < len; right++) {
            if (nums[right] == 0) {
                if (contain == 0) {
                    contain++;
                    continue;
                }
                re = Math.max(re, right - left - 1);
                while (nums[left] != 0) {
                    left++;
                }
                left++;
            }
        }
        if (contain == 0) {
            return len - 1;
        }
        return Math.max(re, right - left - 1);
    }
}
