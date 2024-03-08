package leetcode75.SlideWindow;

//643.子数组最大平均数I
/*给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

任何误差小于 10-5 的答案都将被视为正确答案。*/
//思路:平均数最大 那么总和也最大 用滑动窗口 记录最大和 共有(len-k+1)个窗口
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length, left = 0, right, maxSum = 0, sum = 0;
        for (right = 0; right < k; right++) {
            maxSum += nums[right];
            sum += nums[right];
        }
        for (int i = 1; i <= len - k; i++) {
            sum -= nums[left++];
            sum += nums[right++];
            maxSum = Math.max(maxSum, sum);
        }
        return ((double) maxSum) / k;
    }

    public void test() {
//        double maxAverage = findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
        double maxAverage = findMaxAverage(new int[]{5}, 1);
        System.out.println(maxAverage);
    }

    public static void main(String[] args) {
        new FindMaxAverage().test();
    }
}
