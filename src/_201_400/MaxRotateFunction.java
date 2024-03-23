package _201_400;

//396.旋转函数
/*给定一个长度为 n 的整数数组 nums 。

假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：

F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
返回 F(0), F(1), ..., F(n-1)中的最大值 。

生成的测试用例让答案符合 32 位 整数。*/
//思路:有规律的 每次都是[0,len-1]的加一倍 然后减去[len]的
//可以直接每次都加一倍 然后去掉最后一个元素的贡献
//用一个变量维护0位置的映射
public class MaxRotateFunction {

    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int re = 0, sum = 0, singleSum = 0;
        for (int i = 0; i < len; i++) {
            re += i * nums[i];
            singleSum += nums[i];
        }
        sum = re;
        for (int k = 1; k < len; k++) {
            sum += singleSum;
            sum -= nums[len - k] * len;
            re = Math.max(re, sum);
        }
        return re;
    }

}
