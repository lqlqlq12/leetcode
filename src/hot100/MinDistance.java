package hot100;

//编辑距离
/*给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符*/
//动态规划 dp[i][j] word1[0:i-1]变成word2[0:j-1]的最少步数
// word[i]=word[j] ->dp[i+1][j+1]=dp[i][j]
// word[i]!=word[j] ->dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
public class MinDistance {

    public int minDistance(String word1,String word2){
        int len1=word1.length();
        int len2=word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=0;i<len1+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<len2+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++){
                if(w1[i-1]==w2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[len1][len2];
    }
}
