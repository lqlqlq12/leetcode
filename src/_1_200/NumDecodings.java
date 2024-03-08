package _1_200;

//91.解码方法
/*一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。

给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。*/
//思路:我觉得应该动规 dp[i]表示[0:i]有多少种
//先不考虑0的事情 dp[i]=dp[i-1]+dp[i-2] (理想情况 要考虑 s[i] 和 s[i-1:i]能否构成
public class NumDecodings {
    public int numDecodings(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int[] dp = new int[len + 1];
        if (len == 1) return charArray[0] == '0' ? 0 : 1;
        if (charArray[0] == '0') return 0;
        dp[1] = 1;
        dp[0] = 1;
        if (charArray[0] < '3') {
            if (charArray[1] == '0') {
                dp[2] = 1;
            } else {
                if (charArray[0] == '2' && charArray[1] > '6') {
                    dp[2] = 1;
                } else {
                    dp[2] = 2;
                }
            }
        } else {
            if (charArray[1] == '0') {
                return 0;
            } else {
                dp[2] = 1;
            }
        }
        for (int i = 3; i <= len; i++) {
            if (charArray[i - 1] == '0') {
                if (charArray[i - 2] != '1' && charArray[i - 2] != '2') {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];
                }
            } else {
                if (charArray[i - 2] > '2') {
                    dp[i] = dp[i - 1];
                } else if (charArray[i - 2] == '0') {
                    dp[i] = dp[i - 3];
                } else if (charArray[i - 2] == '1') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    if (charArray[i - 1] > '6') {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + dp[i - 2];
                    }
                }
            }
        }
        return dp[len];
    }

    public void test() {
        numDecodings("1201234");
    }

    public static void main(String[] args) {
        new NumDecodings().test();
    }
}