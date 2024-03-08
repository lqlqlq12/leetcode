package leetcode75.Heap_PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

//2462.雇佣k位工人的总代价
/*给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。

同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：

总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
一位工人只能被选择一次。
返回雇佣恰好 k 位工人的总代价。*/
//思路:可以用两个小堆来存两端的工人 也可以用一个堆来解决,需要记录前端的最右和后端的最左下标 来决定出堆之后哪个需要进堆
//优化:堆里不要放在数组中的下标,直接放数组的元素
public class TotalCost {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (costs[o1] == costs[o2]) {
                    return o1 - o2;
                }
                return costs[o1] - costs[o2];
            }
        });
        int left, right;
        for (left = 0; left < candidates; left++) {
            heap.offer(left);
        }
        for (right = len - 1; right >= left && len - right <= candidates; right--) {
            heap.offer(right);
        }
        long re = 0;
        for (int i = 0; i < k; i++) {
            int index = heap.poll();
            re += costs[index];
            if (left <= right) {
                if (index < left) {
                    heap.offer(left++);
                } else {
                    heap.offer(right--);
                }
            }
        }
        return re;
    }

    public long optimize(int[] costs, int k, int candidates) {
        int len = costs.length;
        long re = 0;
        PriorityQueue<Integer> lh = new PriorityQueue<>();
        PriorityQueue<Integer> rh = new PriorityQueue<>();
        int left = 0, right = len - 1;
        for (int i = 0; i < candidates; i++) {
            if (left <= right) {
                lh.offer(costs[left++]);
            }
            if (left <= right) {
                rh.offer(costs[right--]);
            }
        }
        for (int i = 0; i < k; i++) {
            int l = lh.isEmpty() ? Integer.MAX_VALUE : lh.peek();
            int r = rh.isEmpty() ? Integer.MAX_VALUE : rh.peek();
            if (l <= r) {
                lh.poll();
                re += l;
                if (left <= right) {
                    lh.offer(costs[left++]);
                }
            } else {
                rh.poll();
                re += r;
                if (left <= right) {
                    rh.offer(costs[right--]);
                }
            }
        }
        return re;
    }
}
