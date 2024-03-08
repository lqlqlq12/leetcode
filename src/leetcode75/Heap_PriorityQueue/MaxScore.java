package leetcode75.Heap_PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

//2452.最大子序列的分数
/*给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。

对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：

nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
用公式表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
请你返回 最大 可能的分数。

一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。*/
//思路:暂时没有好的办法 先用回溯试一下啊
//暴力递归超时了 用贪心+优先队列的方法
//先对nums2降序排序 这样会尽可能的让 sum()*min(nums2[])->x*y 的y尽可能大
//其实就是相当于 y从大取到小 然后sum是y的值是特定时 进可能sum()大 就用到了优先队列
public class MaxScore {
    /*int[] nums1, nums2, used;
    int len, k;
    long re;

    public long maxScore(int[] nums1, int[] nums2, int k) {
        re = Long.MIN_VALUE;
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.k = k;
        len = nums1.length;
        used = new int[k];
        backTrack(0, 0, Integer.MAX_VALUE);
        return re;
    }


    public void backTrack(int index, int number, int min) {
        if (number == k) {
            long t = 0l;
            for (int i = 0; i < k; i++) {
                t += nums1[used[i]];
            }
            re = Math.max(re, t * min);
            return;
        }
        for (int i = index; i < len; i++) {
            used[number] = i;
            backTrack(i + 1, number + 1, Math.min(min, nums2[i]));
        }
    }*/

    //太慢了
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (nums2[b] - nums2[a]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int len = nums1.length;
        long re = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < len; i++) priorityQueue.offer(i);
        while (!priorityQueue.isEmpty()) {
            int index = priorityQueue.poll();
            sum += nums1[index];
            heap.offer(nums1[index]);
            if (heap.size() == k) {
                re = Math.max(re, sum * nums2[index]);
                sum -= heap.poll();
            }

        }
        return re;
    }

    //比上一个快了点
    public long optimize(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int len = nums1.length;
        long re = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < len; i++) priorityQueue.offer(new int[]{nums2[i], i});
        while (!priorityQueue.isEmpty()) {
            int index = priorityQueue.poll()[1];
            sum += nums1[index];
            heap.offer(nums1[index]);
            if (heap.size() == k) {
                re = Math.max(re, sum * nums2[index]);
                sum -= heap.poll();
            }

        }
        return re;
    }

    //更快了 到平均了
    public long optimize_1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int len = nums1.length;
        Integer[] idx = new Integer[len];
        long re = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < len; i++) idx[i] = i;
        Arrays.sort(idx, (x, y) -> nums2[y] - nums2[x]);
        for (int i = 0; i < len; i++) {
            int index = idx[i];
            sum += nums1[index];
            heap.offer(nums1[index]);
            if (heap.size() == k) {
                re = Math.max(re, sum * nums2[index]);
                sum -= heap.poll();
            }

        }
        return re;
    }

    //最快 桶排序 用空间狠狠地换时间
}
