package _1_200;

import java.util.Arrays;

//115.不同的子序列
/*给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。*/
//我一猜是动规 dp[i][j] t[0:i]在s[0:j]的子序列中出现的次数
//t[i]==s[j]->dp[i][j]=dp[i-1][j-1]+dp[i][j-1] 分别是使用s[j]和不使用s[j]
//t[i]!=s[j]->dp[i][j]=dp[i][j-1]
//dp[i][0]=0 dp[0][i]=1
//后面可以优化成一维的吧 进一步优化 i>j时 dp[i][j]=0
public class NumDistinct {
    public int numDistinct(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int sLen = sArray.length, tLen = tArray.length;
        int[][] dp = new int[tLen + 1][sLen + 1];
        for (int i = 0; i <= tLen; i++) dp[i][0] = 0;
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= tLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (tArray[i - 1] == sArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLen][sLen];
    }

    public int optimize(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int sLen = sArray.length, tLen = tArray.length;
        int[] dp = new int[sLen + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        for (int i = 1; i <= tLen; i++) {
            int pre = i == 1 ? 1 : dp[i - 1];
            dp[i - 1] = 0;
            for (int j = i; j <= sLen; j++) {
                int temp = dp[j];
                if (tArray[i - 1] == sArray[j - 1]) {
                    dp[j] = dp[j - 1] + pre;
                } else {
                    dp[j] = dp[j - 1];
                }
                pre = temp;
            }
        }
        return dp[sLen];
    }

    public void test() {
        optimize("rabbbit", "rabbit");
    }

    public static void main(String[] args) {
        new NumDistinct().test();
    }
}
