package _201_400;

//343.整数拆分
/*给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

返回 你可以获得的最大乘积 */
//官解证明:最优拆分的结果不会有大于等于4的数字在 如果有 就从里面拿出一个2 2(x-2)=2x-4 因为x>4 所以 2x-4>x
//所以不会有大于等于4的
//最优解的2的个数不会大于等于3个 如果有3个 那么2*2*2可以用3*3替换
//所以只有三种可能了 0,1,2个2
//动规 O(n)
//数学 O(1)
public class IntegerBreak {
    //动规解法
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

    public int optimize(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, n / 3);
        }
        if (mod == 1) {
            return 4 * (int) Math.pow(3, (n - 4) / 3);
        } else {
            return 2 * (int) Math.pow(3, (n - 2) / 3);
        }
    }
}
