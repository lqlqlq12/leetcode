package _201_400;

//264.丑数II
/*给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是质因子只包含 2、3 和 5 的正整数。*/
//思路:一眼动规 丑数只能是2*3*5... 所以知道了dp[0:i-1]肯定是知道dp[i]的 是dp[0:i-1]分别乘2/3/5所得到的
//结果中 大于dp[i-1]且尽可能小
//注意范围 这样做的确是动规 但好像很慢
//看了官解 用三个指针 p2,p3,p5指向三个数 下一个丑数只能是 p2*2、p3*3、p5*5当中的最小值
//谁取最小 哪个指针就右移1
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1, lastIndex = 0, min = Integer.MAX_VALUE; i < n; i++) {
            int j;
            for (j = lastIndex; j < i && dp[j] * 5 <= dp[i - 1]; j++) ;
            lastIndex = j;
            for (; j < i; j++) {
                if (dp[j] * 2L > dp[i - 1]) {
                    min = (int) Math.min(min, dp[j] * 2L);
                    break;
                } else if (dp[j] * 3L > dp[i - 1]) {
                    min = (int) Math.min(min, dp[j] * 3L);
                } else {
                    min = (int) Math.min(min, dp[j] * 5L);
                }
            }
            dp[i] = min;
            min = Integer.MAX_VALUE;
        }
        return dp[n - 1];
    }

    public int optimize(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num1 = 2 * dp[p2], num2 = 3 * dp[p3], num3 = 5 * dp[p5];
            dp[i] = Math.min(num1, Math.min(num2, num3));
            if (dp[i] == num1) {
                p2++;
            }
            if (dp[i] == num2) {
                p3++;
            }
            if (dp[i] == num3) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new NthUglyNumber().optimize(10);
    }
}
