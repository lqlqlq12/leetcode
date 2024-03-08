package _201_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//327.区间和的个数
/*给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。

区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。*/
//大白话就是 求有多少个区间 满足区间的元素和在范围内
//又是前缀和 又是可以用线段树 树状数组 归并了
//归并:先求前缀和 然后对于左部分的 xi 在右边维护两个指针l,r [l,r]范围内的和xi满足[lower,upper]
//然后当xi右移时 l,r也只会右移 这样对于xi 就统计出了和右边满足条件的个数 接下来就要统计左边里面和xi满足条件的个数了
//树状数组 还是先求前缀和 然后对前缀和去重排序 用二分查找得到下标index1和index2
//index1是<sum[i]-lower并且尽可能大的 index2是满足<=nums[i]+upper并且尽可能大的 然后就是query(index2)-query(index1)
public class CountRangeSum {
    long[] sumArray;
    long[] sorted;
    int[] occurArray;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length, re = 0;
        long sum = 0;
        sumArray = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sumArray[i] = sum;
            sum += nums[i];
        }
        sumArray[len] = sum;
        setAndSort(sumArray);
        for (int i = 0; i <= len; i++) {
            //[sumArray[i]-upper,sumArray[i]-lower]
            int rightIndex = getIndex(sumArray[i] - lower);
            int leftIndex = getIndex(sumArray[i] - upper - 1);
            re += (query(rightIndex) - query(leftIndex));
            update(getIndex(sumArray[i]));
        }
        return re;
    }

    public void setAndSort(long[] nums) {
        Set<Long> set = new HashSet<>();
        for (long num : nums) {
            set.add(num);
        }
        int size = set.size(), index = 0;
        sorted = new long[size];
        occurArray = new int[size];
        for (Long num : set) {
            sorted[index++] = num;
        }
        Arrays.sort(sorted);
    }

    //返回<=num的元素中最大的那个的下标 注意 此下标从1开始
    public int getIndex(long num) {
        int left = -1, right = sorted.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (sorted[mid] > num) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right + 1;
    }

    public int lowBit(int n) {
        return n & (-n);
    }

    public void update(int index) {
        while (index <= occurArray.length) {
            occurArray[index - 1]++;
            index += lowBit(index);
        }
    }

    public int query(int index) {
        int re = 0;
        while (index > 0) {
            re += occurArray[index - 1];
            index &= (index - 1);
        }
        return re;
    }

    @Test
    public void test() {
        countRangeSum(new int[]{0}, 0, 0);
    }
}
