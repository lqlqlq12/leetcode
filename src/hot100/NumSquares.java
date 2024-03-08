package hot100;

import java.util.Arrays;

//完全平方数
/*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。*/
//13=4+9
//带记忆的回溯
//动态规划 f[i]=1+min(f[i-j*j])
//四平方和定理:四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和
//当且仅当 n≠4^k×(8m+7)n 可以被表示为至多三个正整数的平方和。
//因此，当 n=4^k×(8m+7)时,n 只能被表示为四个正整数的平方和。此时我们可以直接返回4。
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public int func(int n) {
        if(isSquare(n)){
            return 1;
        }
        int number = n;
        while (number%4==0){
            number/=4;
        }
        if(number%8==7) {
            return 4;
        }
        for(int i=1;i*i<n;i++){
            if(isSquare(n-i*i)){
                return 2;
            }
        }
        return 3;
    }

    //判断是否是完全平方数
    public boolean isSquare(int n){
        int t=(int)Math.sqrt(n);
        return t*t==n;
    }
}
