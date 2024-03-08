package typical150.DynamicPrograming;

import java.util.Arrays;
import java.util.List;

//三角形最小路径和
/*给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。*/
//思路: 应该用动规把
//进一步优化为1维dp 注意 更新dp[i][j]和dp[i-1][j-1],dp[i-1][j] 所以更新1维dp的时候要从右到左
//可以更快 Arrays.fill为Integer.MAX_VALUE 的目的无非是针对每一行的最后一个 不用Arrays.fill() 直接特殊处理最后一个可以更快
//代码可以更优雅 从底层向上遍历dp
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[m][n];
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            re = Math.min(re, dp[m - 1][i]);
        }
        return re;
    }


    public int func(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n];
        int re = Integer.MAX_VALUE;
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        for (int i = 0; i < n; i++) {
            re = Math.min(re, dp[i]);
        }
        return re;
    }

    public int optimize(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
