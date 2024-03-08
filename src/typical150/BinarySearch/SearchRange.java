package typical150.BinarySearch;

//34.在排序数组中查找元素的第一个和最后一个位置
/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。*/
//思路:做过 非常easy 直接两次二分搞定
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] re = new int[]{-1, -1};
        if (right == -1) {
            return re;
        }
        //左边界
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target) {
            return re;
        }
        re[0] = left;
        right = nums.length - 1;
        //右边界
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        re[1] = left;
        return re;
    }

}
