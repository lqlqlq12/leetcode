package _1_200;

//96.不同的二叉搜索树
/*给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？

返回满足题意的二叉搜索树的种数*/
//树一般都是递归 但这回不是 递归可以解决问题 但非常慢 用动规
//动规 dp[i]表示i个节点值连续的结点可以构成的树的数量 所以dp[i]=
public class NumTrees {
    public int numTrees(int n) {
        return recursion(1, n);
    }

    public int recursion(int start, int end) {
        int re = 0;
        if (start >= end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            re += recursion(start, i - 1) * recursion(i + 1, end);
        }
        return re;
    }

    public int dynamicProgramming(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
