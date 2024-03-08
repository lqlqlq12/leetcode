package typical150.Heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//502.IPO
/*假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。

给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。

最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。

总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。

答案保证在 32 位有符号整数范围内。*/
//思路 动规 dp[i]:完成i个项目后最多的总资本 超时了
//官解:贪心 每次都从可以完成的项目中选择利润最高的 可以用大根堆的特性获取最高利润的 只有可以完成的项目才可以入堆
public class FindMaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[] dp = new int[k + 1];
        dp[0] = w;
        int re = 0;
        for (int i = 1; i <= k; i++) {
            int index = 0;
            for (int j = 0; j < len; j++) {
                if (dp[i - 1] >= capital[j]) {
                    if (profits[j] + dp[i - 1] > dp[i]) {
                        dp[i] = profits[j] + dp[i - 1];
                        index = j;
                    }
                }
            }
            re = Math.max(re, dp[i]);
            capital[index] = 1000000001;
        }
        return re;
    }

    public int optimize(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int re = w;
        k = Math.min(k, len);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);
        PriorityQueue<Integer> sorted = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        for (int i = 0; i < len; i++) {
            sorted.offer(i);
        }
        while (k > 0) {
            //将可以完成的项目放入大根堆
            while (!sorted.isEmpty() && re >= capital[sorted.peek()]) {
                queue.offer(sorted.poll());
            }
            //有可以完成的项目
            if (!queue.isEmpty()) {
                re += profits[queue.poll()];
                k--;
            } else break;
        }
        return re;
    }

}
