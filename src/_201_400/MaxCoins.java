package _201_400;

import org.junit.Test;

//312.戳气球
/*有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。

这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。

如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。

求所能获得硬币的最大数量。*/
//官解:用动规 dp[i][j]表示[i+1:j-1]能获得的硬币的最大数量
//则dp[i][j]=Max{nums[i]*nums[k]*nums[j]+dp[i][k]+dp[k][j]} i<k<j k是最后一个戳破的气球
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[][] dp = new int[len][len];
        int[] arr = new int[len];
        arr[0] = arr[len - 1] = 1;
        System.arraycopy(nums, 0, arr, 1, len - 2);
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                int j = i + l - 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], arr[i] * arr[k] * arr[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][len - 1];
    }

    // 3 1 5 15+15+5=25
    @Test
    public void test() {
        maxCoins(new int[]{3, 1, 5, 8});
    }

}
