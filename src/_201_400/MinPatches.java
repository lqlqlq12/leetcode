package _201_400;

//330.按要求补齐数组
/*给定一个已排序的正整数数组 nums ，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，

使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。

请返回 满足上述要求的最少需要补充的数字个数 。*/
//不知道怎么做 看官解把
//官解 贪心:如果覆盖了[1:x-1] 然后缺失x 则添加x后 覆盖范围为[1:2x-1]
//初始x=1 表示没有覆盖范围 如果nums[index]<x 则覆盖范围变为[1:nums[index]+x-1] 也就是x=x+nums[index]
//如果nums[index]==x 则覆盖范围为[1:2x-1] 也就是x=2*x=x+nums[index]
//如果nums[index]>x 说明[x-nums[index]-1]缺失 此时从[1,n]选取x添加到nums中 覆盖范围变为[1:2x-1]
public class MinPatches {
    public int minPatches(int[] nums, int n) {
        int len = nums.length, index = 0, re = 0;
        long x = 1;
        while (x <= n) {
            if (index < len && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                re++;
            }
        }
        return re;
    }
}
