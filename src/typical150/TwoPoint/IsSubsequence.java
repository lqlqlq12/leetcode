package typical150.TwoPoint;

//判断子序列
/*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：

如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？*/
//进阶处理:动规 预处理一遍t,找出t的每一个位置开始,每个字母的下一次出现的位置
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        if (sLen > tLen) {
            return false;
        }
        int i, j;
        for (i = 0, j = 0; i < sLen && j < tLen; ) {
            if (sArray[i] == tArray[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == sLen;
    }

    public boolean dp(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[][] dp = new int[tLen][26];
        for (int i = 0; i < 26; i++) {
            dp[tLen - 1][i] = tLen;
        }
        dp[tLen - 1][t.charAt(tLen - 1) - 'a'] = tLen - 1;
        for (int i = tLen - 2; i >= 0; i--) {
            dp[i][t.charAt(i) - 'a'] = i;
            for (int j = 0; j < 26; j++) {
                if (j == t.charAt(i) - 'a') {
                    continue;
                }
                dp[i][j] = dp[i + 1][j];
            }
        }
        int index = 0;
        int i;
        for (i = 0; i < sLen&&index<tLen; i++) {
            index = dp[index][s.charAt(i) - 'a'];
            if (index == tLen) {
                return false;
            }
            index++;
        }
        return i==sLen;
    }

    public void test() {
        String s = "abc", t = "ahbgdc";
        System.out.println(dp(s, t));
    }

    public static void main(String[] args) {
        new IsSubsequence().test();
    }
}
