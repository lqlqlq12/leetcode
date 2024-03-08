package typical150.Array_String;

import typical150.Array_String.RomanToInt;

//移除元素
/*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。*/
//思路 一次遍历,左右指针,左指针是不等于val的,右指针负责遍历
//优化: 1 2 3 4 5 val为1时 要交换4次 但如果把5换到1的位置就好了 可以头尾两个指针向中间靠拢
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0, len = nums.length;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


    public int twoPoint(int[] nums, int val) {
        int len = nums.length;
        int left = 0, right = len - 1;
        for (; left <= right; ) {
            while (left <= right && nums[left] != val) {
                left++;
            }
            while (left <= right && nums[right] == val) {
                right--;
            }
            if (left <= right) {
                nums[left] = nums[right];
                left++;
                right--;
            } else {
                return left;
            }
        }
        return left;
    }
}
