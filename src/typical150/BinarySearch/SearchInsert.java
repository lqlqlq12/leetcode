package typical150.BinarySearch;

//35.搜索插入位置
/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法*/
//nums 为 无重复元素 的 升序 排列数组
//一眼二分 找到一个位置i 使得nums[i-1]<target nums[i]>=target
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }
}
