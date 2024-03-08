package _1_200;

import java.util.Arrays;

//87.扰乱字符串
/*使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
如果字符串的长度为 1 ，算法停止
如果字符串的长度 > 1 ，执行下述步骤：
在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。*/
//思路:没有好的思路 除了递归 一看果然会暴力
//官解:动规 让我想想
//想不出来 dp[i][j][k] s1从i开始 s2从j开始 长度为k 是否匹配
//自底向下 记忆化搜索 如果两个字符串相等 则匹配 如果两个字符串某个字符的出现次数不一致 则肯定不匹配
//由于s1和s2只由小写字母组成 所以可以用长度26的
public class IsScramble {
    int[][][] dp;
    String s1, s2;
    int sLen;

    public boolean isScramble(String s1, String s2) {
        this.sLen = s1.length();
        dp = new int[sLen][sLen][sLen + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, sLen);
    }

    public boolean dfs(int i1, int i2, int length) {
        if (dp[i1][i2][length] != 0) {
            return dp[i1][i2][length] == 1;
        }
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            dp[i1][i2][length] = 1;
            return true;
        }

        int[] arr1 = new int[26], arr2 = new int[26];
        for (int i = i1; i < i1 + length; i++) {
            arr1[s1.charAt(i) - 'a']++;
        }
        for (int i = i2; i < i2 + length; i++) {
            arr2[s2.charAt(i) - 'a']++;
        }
        if (!Arrays.equals(arr1, arr2)) {
            dp[i1][i2][length] = -1;
            return false;
        }

        //分割 [i1,i1+length-1] [i2,i2+length-1]
        for (int i = 1; i < length; i++) {
            //不交换
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                dp[i1][i2][length] = 1;
                return true;
            }
            //交换
            if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                dp[i1][i2][length] = 1;
                return true;
            }
        }

        dp[i1][i2][length] = -1;
        return false;
    }

    public void test() {
        isScramble("abc", "acb");
    }

    public static void main(String[] args) {
        new IsScramble().test();
    }
}
