package _201_400;

//357.统计各位数字都不相同的数字个数
/*给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。*/
//1000 4位 0-999 只有1位10,2位81 3位 9*9*8=648 10 81 648
//100 2位 0-99 第一位:9 第二位[0-9]-1 9 81+第一位:0 第二位:0-9 10 81+10=91
//从i位向i+1位 首先i+1位不能是0 i+1位:i位内有0 (9-i+1) i位内没有0 (9-i)
//可以用动规 记录i位数字带0和不带0的个数 就可以得到i+1位数字带0和不带0的个数
//dp[i][2] dp[i][0]i位数字带0 dp[i][1]i位数字不带0
//dp[i][0]=(dp[i-1][0](i-1不为0)+dp[i-2][1](i-1为0))*(9-i+2)
//dp[i][1]=dp[i-1][1]*(9-i+1)
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[][] dp = new int[n + 1][2];
        int re = 10;
        dp[1][0] = 1;
        dp[1][1] = 9;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][1]) * (9 - i + 2);
            dp[i][1] = dp[i - 1][1] * (9 - i + 1);
            re += dp[i][0];
            re += dp[i][1];
        }
        return re;
    }
}
