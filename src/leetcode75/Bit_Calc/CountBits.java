package leetcode75.Bit_Calc;

//338.比特位计数
/*给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
返回一个长度为 n + 1 的数组 ans 作为答案。*/
//我是sb
//如果y=2*x则y就是x左移1 所以dp[y]=dp[y/2]=dp[x]
//如果y=2*x+1那么就是x左移1并将最后一位变成1 所以dp[y]=dp[y/2]+1=dp[x]+1
//x&(x-1)将最后一个1变成0 操作多少次就有多少个1
public class CountBits {
    public int[] countBits(int n) {
        int[] re = new int[n + 1];
        re[0] = 0;
        if (n >= 1) re[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                re[i] = re[i / 2];
            } else {
                re[i] = re[i / 2] + 1;
            }
        }
        return re;
    }
}
