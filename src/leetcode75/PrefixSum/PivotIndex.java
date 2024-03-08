package leetcode75.PrefixSum;

//724.寻找数组的中心下标
/*给你一个整数数组 nums ，请计算数组的 中心下标 。

数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。

如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。*/
//思路:两次遍历 第一次遍历 求累加和 求得元素左侧的元素和
//优化:不用存储左前缀和 第一次遍历求总和 第二次求累计和 一样的时间复杂度
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] rightSum = new int[len];
        for (int i = len - 1, sum = 0; i >= 0; i--) {
            rightSum[i] = sum;
            sum += nums[i];
        }
        for (int i = 0, sum = 0; i < len; i++) {
            sum += nums[i];
            nums[i] = sum - nums[i];
            if (nums[i] == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }

    public int optimize(int[] nums) {
        int len = nums.length, total = 0;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        for (int i = 0, sum = 0; i < len; i++) {
            if (sum == total - sum - nums[i]) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
