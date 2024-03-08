package leetcode75.Array_String;

//334.递增的三元子序列
/*给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。*/
//思路:贪心或动规 之前有最长递增子序列
//动规 int[] arr arr[i]表示长度为i的最小的 k表示当前的最大长度 如果nums[i]<arr[k] 则替换arr[1:k]的一个 用二分
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0], b = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] > b) {
                return true;
            }
            if (nums[i] > a) {
                b = Math.min(nums[i], b);
            } else {
                a = nums[i];
            }
        }
        return false;
    }
}
