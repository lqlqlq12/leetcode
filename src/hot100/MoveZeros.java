package hot100;


//移动零
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作*/
/*尽量减少完成的操作次数*/
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[l++] = nums[i];
            }
        }
        for (; l < nums.length; l++) {
            nums[l] = 0;
        }
    }
}
