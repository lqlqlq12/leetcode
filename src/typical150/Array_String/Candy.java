package typical150.Array_String;

import java.util.LinkedList;
import java.util.Queue;

//分发糖果
/*n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

你需要按照以下要求，给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻两个孩子评分更高的孩子会获得更多的糖果。
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。*/
//思路一:把可以分配为1个糖果的孩子作为初始节点, 这样好像不行 1,3,4,5,2
//思路二:两次遍历 从左到右 再从右到左 好像可以哈 (官方解法...感动)
//空间优化的一个巧妙的思路: 当遇到递减序列时,从1开始 逐个加1 原本应该3 2 1 的糖果过就变成了 1 2 3 这样结果也一样
public class Candy {
    public int one(int[] ratings) {
        int len = ratings.length;
        int re = 0;
        if (len < 2) {
            return 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        //不会比左右两边大的就可以发1个candy
        if (ratings[0] <= ratings[1])
            queue.offer(0);
        if (ratings[len - 1] <= ratings[len - 2])
            queue.offer(len - 1);
        for (int i = 1; i < len - 1; i++) {
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer index = queue.poll();
                if (index > 0 && ratings[index - 1] > ratings[index] && !queue.contains(index - 1)) {
                    queue.offer(index - 1);
                }
                if (index < len - 1 && ratings[index + 1] > ratings[index] && !queue.contains(index + 1)) {
                    queue.offer(index + 1);
                }
            }
        }
        return re;
    }

    public int two(int[] ratings) {
        int len = ratings.length;
        int re = 0;
        if (len < 2) {
            return 1;
        }
        int[] candy = new int[len];
        if (ratings[0] <= ratings[1])
            candy[0] = 1;
        if (ratings[len - 1] <= ratings[len - 2])
            candy[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            if (i < len - 1 && ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                candy[i] = 1;
            } else if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    candy[i] = Math.max(candy[i - 1], candy[i + 1]) + 1;
                } else {
                    candy[i] = candy[i + 1] + 1;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            re += candy[i];
        }
        return re;
    }
}
