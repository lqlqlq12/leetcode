package typical150.Kadane;

import java.util.Deque;
import java.util.LinkedList;

//918.环形子数组的最大和
/*给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。

环形数组 意味着数组的末端将会与开头相连呈环状。形式上，
nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。

子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。*/
//思路:动规 dp[i] 以i结尾的最大子数组和 dp[i]=dp[i-1]<0?nums[i]:nums[i]+dp[i-1]
//考虑两种 一个是一团的,一个是左右分开的 一团的很easy 左右分开的
//左右分开的情况 [0:i]and[j:n-1] leftMax[i] nums[0:i]中最大的前缀和 枚举j
//方法二:比较巧妙 求左右分段的最大
//方法三:直接两个一样的数组拼在一起 然后动规 但是很慢很慢
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int len = nums.length;
        int re = nums[0];
        int pre = nums[0];
        int[] leftMax = new int[len];
        int sum = nums[0], rightSum = 0;
        leftMax[0] = sum;
        for (int i = 1; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            re = Math.max(re, pre);
            sum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], sum);
        }
        for (int j = len - 1; j > 0; j--) {
            rightSum += nums[j];
            re = Math.max(re, rightSum + leftMax[j - 1]);
        }
        return re;
    }

    public int method_2(int[] nums) {
        int len = nums.length;
        int max = nums[0], min = nums[0];
        int maxPre = nums[0], minPre = nums[0];
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            maxPre = Math.max(maxPre + nums[i], nums[i]);
            minPre = Math.min(minPre + nums[i], nums[i]);
            max = Math.max(max, maxPre);
            min = Math.min(min, minPre);
            sum += nums[i];
        }
//        if (max < 0) {
//            return max;
//        }
        return Math.max(max, sum - min);
    }

    //很慢很慢
    public int optimize(int[] nums) {
        int len = nums.length;
        int re = nums[0];
        Deque<int[]> queue = new LinkedList<>();
        int sum = nums[0];
        queue.offer(new int[]{0, sum});
        for (int i = 1; i < 2 * len; i++) {
            while (!queue.isEmpty() && queue.peekFirst()[0] < i - len) {
                queue.pollFirst();
            }
            sum += nums[i % len];
            re = Math.max(re, sum - queue.peekFirst()[1]);
            while (!queue.isEmpty() && queue.peekLast()[1] >= sum) {
                queue.pollLast();
            }
            queue.offerLast(new int[]{i, sum});
        }
        return re;
    }
}
