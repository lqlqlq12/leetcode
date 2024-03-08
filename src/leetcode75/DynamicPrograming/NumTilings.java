package leetcode75.DynamicPrograming;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import sun.print.BackgroundLookupListener;

//790.多米诺和诺米诺平铺
/*有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。

给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 109 + 7 取模 的值。

平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，

使得恰好有一个平铺有一个瓷砖占据两个正方形。*/
//多米诺: * *
//诺米诺: * *
//     : *
//思路:回溯吧... 很好 理所当然的超时了
//官解:动规? dp[i][4] 动规到第i列时 0表示两个都没覆盖 1表示只有上面 2表示只有下面 3表示两个都
//动规可以优化成一维的
//有一个规律 f[n]=2*f[n-1]+f[n-3]
public class NumTilings {
//    int re;
//
//    public int numTilings(int n) {
//        re = 0;
//        backTrack(n, 0, 0);
//        return re;
//    }
//
//    public void backTrack(int n, int first, int second) {
//        if (first == n && second == n) {
//            re++;
//            return;
//        }
//        if (first >= n || second >= n) {
//            return;
//        }
//        if (first == second) {
//            backTrack(n, first + 2, second + 2);
//            backTrack(n, first + 1, second + 1);
//            backTrack(n, first + 2, second + 1);
//            backTrack(n, first + 1, second + 2);
//        } else if (first < second) {
//            backTrack(n, first + 2, second + 1);
//            backTrack(n, first + 2, second);
//        } else {
//            backTrack(n, first + 1, second + 2);
//            backTrack(n, first, second + 2);
//        }
//    }

    public int numTilings(int n) {
        int mod = 1000000000 + 7;
        int[][] dp = new int[n][4];
        dp[0][0] = dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][3] % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][3] = ((dp[i][2] + dp[i - 1][2]) % mod + dp[i - 1][3]) % mod;
        }
        return dp[n - 1][3];
    }

    public int optimize(int n) {
        long[] dp = new long[4];
        int mod = 1000000000 + 7;
        dp[0] = dp[3] = 1;
        for (int i = 1; i < n; i++) {
            long t = dp[1];
            long pre = dp[0];
            dp[1] = dp[2] + dp[0];
            dp[2] = t + dp[0];
            dp[0] = dp[3];
            dp[3] = (dp[1] + dp[2] - pre + dp[3]) % mod;
            dp[0] %= mod;
            dp[1] %= mod;
            dp[2] %= mod;
        }
        return (int) dp[3];
    }
}