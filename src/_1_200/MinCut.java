package _1_200;

import java.util.Arrays;

//132.分割回文串II
/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。

返回符合要求的 最少分割次数 。*/
//好tm难啊 先用动规 dp[i][j]表示s[i:j]是否为回文串
//然后再动规 d[i]表示s[0:i]的最少分割次数d[i]=Min(d[j]+1{dp[0:j]==1&&dp[j+1:i]==1})
public class MinCut {
    public int minCut(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        boolean[][] dp = new boolean[len][len];
        int[] d = new int[len];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                int j = i + l - 1;
                if (charArray[i] == charArray[j]) {
                    if (l <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i < len; i++) {
            if (dp[0][i]) {
                d[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    d[i] = Math.min(d[i], d[j] + 1);
                }
            }
        }
        return d[len - 1];
    }
}
