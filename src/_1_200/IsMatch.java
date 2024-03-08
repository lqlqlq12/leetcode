package _1_200;

//10.正则表达式匹配 (动规)
/*给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。*/
//官解:动规 dp[i][j]表示s[0:i]与p[0:j]是否匹配
//s[i]==p[j]||p[j]='.' dp[i][j]=dp[i-1][j-1]
//p[j]=='*
//匹配1次 dp[i][j]=dp[i-1][j-2]
//匹配2次 dp[i][j]=dp[i-2][j-2]
//......
//s[i]!=p[j-1]->dp[i][j]=dp[i-1][j-2]
//s[i]=p[j-1]->dp[i][j]=(可以匹配,但我就是不匹配,重复0次)dp[i-1][j-2]||(匹配1...n次)dp[i-1][j]
//尝试优化成一维的动规 dp[i][j]只与dp[i-1][j-1],dp[i][j-2],dp[i-1][j] 好像不太好优化 不优化了
public class IsMatch {
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        int sLen = sArray.length, pLen = pArray.length;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (pArray[j - 1] != '*') {
                    if (i >= 1 && (pArray[j - 1] == '.' || sArray[i - 1] == pArray[j - 1])) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (i >= 1 && (pArray[j - 2] == '.' || sArray[i - 1] == pArray[j - 2])) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public void test() {
        isMatch("aaa", "aaaa");
    }

    public static void main(String[] args) {
        new IsMatch().test();
    }
}
