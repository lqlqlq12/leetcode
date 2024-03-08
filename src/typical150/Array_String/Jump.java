package typical150.Array_String;

//55.跳跃游戏
/*给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false */
//思路:一次遍历就可以 维护能到达最远的地方
//方法二:倒序 比正序略快 维护至少要到达的目标
public class Jump {
    public boolean canJump(int[] nums) {
        int len = nums.length, far = 0;
        for (int i = 0; i < len && i <= far; i++) {
            far = Math.max(far, i + nums[i]);
            if (far >= len - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean optimize(int[] nums) {
        int len = nums.length, target = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
}
