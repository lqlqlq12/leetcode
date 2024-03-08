package _201_400;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

//321.拼接最大数
/*给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。

现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，

要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。*/
//首先 看到要保持原来的顺序 我想到的是双指针 p q分别记录两个数组上一次选的在哪里
// nums1:6 7 8
// nums2:6 0 4
// k1->8 k2->86 k3->864 k4->8604 k5->78604 k6->678604
// k0(0,0) k1(3,0) k2(3,1) k3(3,3) k4(3,3) k5(3,3)
//原问题的最优解不一定是子问题的最优解
//原来没有什么巧妙的解法
//枚举 从num1取x个 nums2取y个 x+y=k 枚举x[0:k]
//使用单调栈 从nums1取出长度x的递增序列
//太nm复杂了 终于过了
public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] re = new int[m + n];

        for (int i = 0; i <= k && i <= m; i++) {
            if (k - i > n) continue;
            if (i == 0) {
                re = getMaxK(nums2, k);
                continue;
            }
            if (i == k) {
                int[] t = getMaxK(nums1, k);
                if (compare(re, 0, t, 0) < 0) {
                    re = t;
                }
                continue;
            }
            int[] arr1 = getMaxK(nums1, i);
            int[] arr2 = getMaxK(nums2, k - i);
            int[] merge = merge(arr1, arr2);
            if (compare(re, 0, merge, 0) < 0) re = merge;
        }
        return re;
    }

    public int[] getMaxK(int[] nums, int size) {
        Deque<Integer> stack = new LinkedList<>();
        int[] re = new int[size];
        int len = nums.length;
        //i+1 i+2 ...len-1
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek() && stack.size() + len - i - 1 >= size) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for (int index = 0; index < size; index++) {
            re[index] = stack.pollLast();
        }
        return re;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] re = new int[m + n];
        int left = 0, right = 0;
        for (int index = 0; left < nums1.length || right < nums2.length; ) {
            if (left == nums1.length) {
                re[index++] = nums2[right++];
                continue;
            } else if (right == nums2.length) {
                re[index++] = nums1[left++];
                continue;
            }
            if (compare(nums1, left, nums2, right) > 0) {
                re[index++] = nums1[left];
                left++;
            } else {
                re[index++] = nums2[right];
                right++;
            }
        }
        return re;
    }

    //nums1,nums2一样长
    public int compare(int[] nums1, int index1, int[] nums2, int index2) {
        int m = nums1.length, n = nums2.length;
        int i = index1, j = index2;
        for (; i < m && j < n; i++, j++) {
            if (nums1[i] > nums2[j]) {
                return 1;
            } else if (nums1[i] < nums2[j]) {
                return -1;
            }
        }
        return (m - i) - (n - j);
    }


    @Test
    public void test() {
        maxNumber(new int[]{8, 6, 9}, new int[]{1, 7, 5}, 3);
    }


}


