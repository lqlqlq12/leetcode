package _201_400;

import org.junit.Test;

import java.util.Arrays;

//313.超级丑数
/*超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。*/
/*primes 中的所有值都 互不相同 ，且按 递增顺序 排列*/
//思路:借鉴丑数 2 3 5 用 三个指针的做法
//那就维护一个指针数组
public class NthSuperUglyNumber {
    public int nThSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] points = new int[len];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int index = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                long multi = (long) primes[j] * dp[points[j]];
                if (multi == dp[i - 1]) {
                    points[j]++;
                    multi = (long) primes[j] * dp[points[j]];
                }
                if (multi < dp[i]) {
                    dp[i] = (int) multi;
                    index = j;
                }
            }
            points[index]++;
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        nThSuperUglyNumber(45, new int[]{2, 3, 7, 13, 17, 23, 31, 41, 43, 47});
    }
}
