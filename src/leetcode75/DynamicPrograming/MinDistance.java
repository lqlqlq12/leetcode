package leetcode75.DynamicPrograming;

//72.编辑距离
/*给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符*/
//动规 dp[i][j] word1[0:i]转换成word2[0:j]的最少操作数
//word1[i]=word2[j] dp[i][j]=dp[i-1][j-1]
//插入/删除:dp[i][j]=Math,min{dp[i-1][j],dp[i][j-1]}+1
//替换:dp[i][j]=Math.min{dp[i][j],dp[i-1][j-1]+1}
//可以优化成一维的
public class MinDistance {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int len1 = w1.length, len2 = w2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public int optimize(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int len1 = w1.length, len2 = w2.length;
        int[] dp = new int[len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            int pre = dp[0];
            dp[0] = i;
            for (int j = 1; j <= len2; j++) {
                int t = dp[j];
                if (w1[i - 1] == w2[j - 1]) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], pre)) + 1;
                }
                pre = t;
            }
        }
        return dp[len2];
    }
}
