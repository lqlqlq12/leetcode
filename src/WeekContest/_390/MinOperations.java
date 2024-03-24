package WeekContest._390;

import org.junit.Test;

//100228.执行操作使数据元素之和大于等于 K
/*给你一个正整数 k 。最初，你有一个数组 nums = [1] 。

你可以对数组执行以下 任意 操作 任意 次数（可能为零）：

选择数组中的任何一个元素，然后将它的值 增加 1 。
复制数组中的任何一个元素，然后将它附加到数组的末尾。
返回使得最终数组元素之 和 大于或等于 k 所需的 最少 操作次数。*/
//dp? dp[i]=Math.min(dp[i-1]+1,
//思路:肯定是一直先加1 然后再复制 同样的加1次数和复制次数 如果先复制再加1
//加x次 复制y次: (x+number)*y =xy+y*number
//先复制再加 y*number+x
public class MinOperations {
    public int minOperations(int k) {
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            int remain = k - 1 - i;
            int t;
            if (remain % (i + 1) != 0) {
                t = i + remain / (i + 1) + 1;
            } else {
                t = i + remain / (i + 1);
            }
            if (t <= re) {
                re = t;
            } else {
                return re;
            }
        }
        return re;
    }

    @Test
    public void test() {
        System.out.println(minOperations(2));
    }
}
