package leetcode75.DynamicPrograming;

//1137.第N个泰波那契数
/*泰波那契序列 Tn 定义如下：

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数 n，请返回第 n 个泰波那契数 Tn 的值。*/
//思路 递归or迭代 迭代优于递归
//直接递归超时 改用动规 dp[i]=dp[i-1]+dp[i-2]+dp[i-3]
//动规再优化成常数空间 就是迭代了
public class Tribonacci {
    public int tribonacci(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public int optimize(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int t = a + b + c;
            a = b;
            b = c;
            c = t;
        }
        return c;
    }
}
