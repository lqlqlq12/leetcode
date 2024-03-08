package _201_400;

//303.区域和检索 -数组不可变
/*给定一个整数数组  nums，处理以下类型的多个查询:

计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )*/
//一下子没想到 前缀和
//dp[i]=sum(num[0:i-1])
public class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        int len = nums.length;
        dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return dp[right + 1] - dp[left];
    }
}
