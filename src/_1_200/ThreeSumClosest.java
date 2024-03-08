package _1_200;

import java.util.Arrays;

//最接近的三数之和
/*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。*/
//思路:dfs 递归 慢得离谱
//官解:先排序 然后双指针
public class ThreeSumClosest {
    int[] re;
    int[] nums;
    int[] t;
    int min;

    public int threeSumClosest(int[] nums, int target) {
        re = new int[3];
        t = new int[3];
        this.nums = nums;
        re[0] = nums[0];
        re[1] = nums[1];
        re[2] = nums[2];
        min = Math.abs(re[0] + re[1] + re[2] - target);
        dfs(0, target, 0);
        return re[0] + re[1] + re[2];
    }

    public void dfs(int index, int target, int number) {
        if (number == 3) {
            int temp = Math.abs(t[0] + t[1] + t[2] - target);
            if (temp < min) {
                min = temp;
                re[0] = t[0];
                re[1] = t[1];
                re[2] = t[2];
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            t[number] = nums[i];
            dfs(i + 1, target, number + 1);
        }
    }

    public int optimize(int[] nums, int target) {
        int len = nums.length, min = Integer.MAX_VALUE, re = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right], diff = Math.abs(sum + nums[i] - target);
                if (sum == target - nums[i]) {
                    return target;
                } else if (sum > target - nums[i]) {
                    right--;
                } else {
                    left++;
                }
                if (min > diff) {
                    min = diff;
                    re = sum + nums[i];
                }
            }
        }
        return re;
    }
}
