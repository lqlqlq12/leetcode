package _401_600;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//403.青蛙过河
/*一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。

给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃 1 个单位（即只能从单元格 1 跳至单元格 2 ）。

如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。*/
//思路:用动规？ dp[i]表示的是跳了多远到达stones[i] 时间O(n^2) 空间也很大 感觉会超时 没超时 只击败了5% 哈哈
//试一下dfs 好 直接超时了 笑死
//看官解把 官解用记忆化搜索优化了dfs boolean[i][k]表示能不能跳k步然后到达i
public class CanCross {
//    public boolean canCross_1(int[] stones) {
//        int len = stones.length;
//        Set<Integer>[] dp = new Set[len];
//        for (int i = 0; i < len; i++) {
//            dp[i] = new HashSet<>();
//        }
//        dp[0].add(0);
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (dp[j].isEmpty()) continue;
//                int distance = stones[i] - stones[j];
//                if (dp[j].contains(distance) || dp[j].contains(distance - 1) || dp[j].contains(distance + 1)) {
//                    dp[i].add(distance);
//                }
//            }
//        }
//        return !dp[len - 1].isEmpty();
//    }

    int[] stones;
    int len;
    Boolean[][] res;

    public boolean canCross(int[] stones) {
        this.stones = stones;
        this.len = stones.length;
        res = new Boolean[len][len];
        return dfs(0, 0);
    }

    //跨了k步到达index
    public boolean dfs(int index, int k) {
        if (index == len - 1) return true;
        if (res[index][k] != null) {
            return res[index][k];
        }
        for (int dist = k - 1; dist <= k + 1; dist++) {
            if (dist <= 0) continue;
            int nextDes = Arrays.binarySearch(stones, index + 1, len, stones[index] + dist);
            if (nextDes > 0 && dfs(nextDes, dist)) {
                return res[index][k] = true;
            }
        }
        return res[index][k] = false;
    }

    @Test
    public void test() {
        canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
    }
}
