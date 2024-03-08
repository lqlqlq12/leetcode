package _1_200;

//44.通配符匹配
/*给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符序列（包括空字符序列）。
判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。*/
//思路:动规 dp[i][j] 表示s[0:i]与 p[0:j]是否匹配
//p[j]!='*':
//  p[j]=='?'||s[i]==p[j] -> dp[i][j]=dp[i-1][j-1]
//p[j]=='*':
//  *匹配了0次:dp[i][j]=dp[i][j-1]
//  *匹配了1次:dp[i][j]=dp[i-1][j-1]
//  *匹配了2次:dp[i][j]=dp[i-2][j-1]
//因为先匹配1次才有2次
//所以 dp[i][j]=dp[i][j-1]||dp[i-1][j]
public class IsMatch_2 {
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        int sLen = sArray.length, pLen = pArray.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (pArray[j - 1] != '*') {
                    if (i > 0 && (pArray[j - 1] == '?' || sArray[i - 1] == pArray[j - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (dp[i][j - 1]) {
                        dp[i][j] = true;
                        continue;
                    }
                    dp[i][j] = i > 0 && dp[i - 1][j];
                }
            }
        }
        return dp[sLen][pLen];
    }

    public void test() {
        isMatch("aa", "*");
    }

    public static void main(String[] args) {
        new IsMatch_2().test();
    }
}
