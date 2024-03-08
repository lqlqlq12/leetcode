package leetcode75.TwoPoint;

//283.移动零
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。*/
//思路:双指针 将非零的不断往左边塞
public class MoveZeros {
    public void moveZeros(int[] nums) {
        int len = nums.length, left = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        while (left < len) {
            nums[left++] = 0;
        }
    }
}
