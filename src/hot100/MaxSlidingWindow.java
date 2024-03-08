package hot100;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

//滑动窗口最大值
/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。*/
//暴力解法 O(kn)
//优先队列 大顶堆 堆元素是(nums[index],index),对每次堆顶元素判断,将不在窗口中的元素出队 O(nlogn)
//单点队列 队列里存放的都是有可能被选为最大值的值,并且下标递增,对应的值递减,因为如果 i<j&&nums[i]<nums[j] 则nums[i]不可能被选为最大值,不会在队列里
//分块和预处理
public class MaxSlidingWindow {

    //优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] re = new int[len - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        re[0] = queue.peek()[0];
        for (int i = k; i < len; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            re[i - k + 1] = queue.peek()[0];
        }
        return re;
    }

    //单调队列
    public int[] singleQueue(int[] nums, int k) {
        int len = nums.length;
        int[] re = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peek()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        for (int i = k; i < len; i++) {
            re[i - k] = nums[queue.peekFirst()];
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        re[len - k] = nums[queue.peekFirst()];
        return re;
    }

    //分块和预处理 最快
    public int[] func(int[] nums, int k) {
        int len = nums.length;
        int[] prefixMax = new int[len];
        int[] suffixMax = new int[len];
        for (int i = 0; i < len; i++) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            } else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if ((i + 1) % k == 0 || i == len - 1) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }
        int[] re = new int[len - k + 1];
        for (int i = 0; i < len - k; i++) {
            re[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return re;
    }
}
