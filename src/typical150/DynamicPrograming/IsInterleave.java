package typical150.DynamicPrograming;

//交错字符串
/*给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
注意：a + b 意味着字符串 a 和 b 连接*/
//思路:动规 dp[i][j]含义s[0:i-1]和t[0:j-1]能否交替组成s3[0:i+j-1]
//不用管|n-m|<=1 如果|n-m|=2 说明有 sttt的情况 那么可以转换为st'
//先用二维做完 再看看能不能优化成一维dp
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        char[] s3Array = s3.toCharArray();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (!dp[i][j] && i > 0 && s1Array[i - 1] == s3Array[i + j - 1] && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (!dp[i][j] && j > 0 && s2Array[j - 1] == s3Array[i + j - 1] && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[len1][len2];
    }

    public boolean optimize(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        char[] s3Array = s3.toCharArray();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0 && s1Array[i - 1] == s3Array[i + j - 1] && dp[j]) {
                    continue;
                }
                if (i > 0) {
                    dp[j] = false;
                }
                if (j > 0 && s2Array[j - 1] == s3Array[i + j - 1] && dp[j - 1]) {
                    dp[j] = true;
                }
            }
        }
        return dp[len2];
    }

    public boolean optimize_2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        char[] s3Array = s3.toCharArray();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;
        //先处理第一行
        for (int i = 1; i <= len2; i++) {
            if (s2Array[i - 1] == s3Array[i - 1] && dp[i - 1]) {
                dp[i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= len1; i++) {
            dp[0] = dp[0] && s1Array[i - 1] == s3Array[i - 1];
            for (int j = 1; j <= len2; j++) {
                dp[j] = (dp[j] && s1Array[i - 1] == s3Array[i + j - 1]) || (dp[j - 1] && s2Array[j - 1] == s3Array[i + j - 1]);
            }
        }
        return dp[len2];
    }
}
