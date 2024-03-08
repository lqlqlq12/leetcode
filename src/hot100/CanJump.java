package hot100;

//跳跃游戏
/*给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。*/
//从前往后遍历,维护最远到达距离
//从后往前遍历,更快 维护要到达的下标
public class CanJump {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxDistance = 0;
        for (int i = 0; i < length; i++) {
            if (i <= maxDistance) {
                maxDistance = Math.max(maxDistance, nums[i] + i);
                if (maxDistance >= length - 1)
                    return true;
            }
        }
        return maxDistance >= length - 1;
    }

    public boolean tailToHead(int[] nums) {
        int len = nums.length;
        int targetIndex = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= targetIndex) {
                targetIndex = i;
            }
        }
        return targetIndex == 0;
    }
}
