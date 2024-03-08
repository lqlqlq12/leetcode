package typical150.DynamicPrograming;

import java.util.Arrays;

//5.最长回文子串
/*给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串*/
//思路:(错误 原问题最优解不一定包含子问题最优解)动规 dp[i]以s[i]结尾的最长回文串的长度 s[i]=s[i-dp[i-1]-1] dp[i]=dp[i-1]+2
//思路:用dp[i][j] 表示[i...j]是不是一个回文串 s[i]=s[j] dp[i][j]=dp[i+1][j-1]+2
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length, maxLen = 1, maxIndex = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int L = 2; L <= len; L++) {
            for (int left = 0; left < len; left++) {
                int right = left + L - 1;
                if (right >= len) {
                    break;
                }
                if (charArray[left] != charArray[right]) {
                    dp[left][right] = false;
                    continue;
                } else {
                    if (L == 2) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    maxIndex = left;
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLen);
    }

    public void test() {
        longestPalindrome("ccc");
    }

    public static void main(String[] args) {
        new LongestPalindrome().test();
    }


}
