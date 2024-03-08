package leetcode75.DynamicPrograming;

//1143.最长公共子序列
/*给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。*/
//忘记怎么做了
//动规 dp[i][j] [0:i][0:j]的最长公共子序列的长度
//text1[i]=text2[j] dp[i][j]=dp[i-1][j-1]+1 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])
//优化 dp[i][j]和dp[i-1][j] dp[i][j-1] dp[i-1][j-1]有关 可以优化为一维的 O(n)
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int len1 = t1.length, len2 = t2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public int optimize(String text1, String text2) {
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        int len1 = t1.length, len2 = t2.length;
        int[] dp = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            int pre = dp[0];
            for (int j = 1; j <= len2; j++) {
                int t = dp[j];
                if (t1[i - 1] == t2[j - 1]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = t;
            }
        }
        return dp[len2];
    }
}
