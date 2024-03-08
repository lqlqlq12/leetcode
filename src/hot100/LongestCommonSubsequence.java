package hot100;

//最长公共子序列
/*给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。*/
//一眼动规 dp[i][j] text1[i]=text2[j]->dp[i][j]=dp[i-1][j-1];
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int[][] dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(t1[i-1]==t2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    //将二维数组优化成一维的
    public int func(String text1,String text2){
        int len1=text1.length();
        int len2=text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int[] dp=new int[len2+1];
        int[] t=new int[len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(t1[i-1]==t2[j-1]){
                    t[j]=1+dp[j-1];
                }
                else{
                    t[j]=Math.max(dp[j],t[j-1]);
                }
                if(j>2){
                    dp[j-2]=t[j-2];
                }
                if(j==len2){
                    dp[len2-1]=t[len2-1];
                    dp[len2]=t[len2];
                }
            }
        }
        return dp[len2];
    }
}
