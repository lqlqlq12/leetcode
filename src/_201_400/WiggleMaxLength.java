package _201_400;

//376.摆动序列
/*如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。

例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。

相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。

给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 */
//思路:动规 dp[i][2] dp[i]表示i作为摆动序列的最后一个元素时的最长子序列长度
//dp[i][0]表示元素大于前一个 dp[i][1]表示元素小于前一个
//动规才击败5% 有更好的解法 再想想
//我的动规要O(n^2) 官解的只要O(n) 还可以优化成一维的
//官解的动规 dp[i][2]表示[0:i]的最长摆动序列的长度
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length, re = 1;
        int[][] dp = new int[len][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                    re = Math.max(re, dp[i][0]);
                } else if (nums[j] > nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                    re = Math.max(re, dp[i][1]);
                }
            }
        }
        return re;
    }

    public int optimize(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + 1);
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
