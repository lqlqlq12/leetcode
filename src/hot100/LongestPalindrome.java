package hot100;

/*给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。*/
//最长回文字串

//动态规划
//中心扩展
public class LongestPalindrome {

    public static void main(String[] args) {
        String s="ac";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s){
        int length=s.length();
        int max=1;
        int begin=0;

        if(length<2)
            return s;

        boolean[][] dp=new boolean[length][length];

        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }

        for(int L=2;L<=length;L++){
            for(int i=0;i+L<=length;i++){
                int j=i+L-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(j==i+1){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                else{
                    dp[i][j]=false;
                }

                if(dp[i][j]){
                    if(L>max){
                        max=L;
                        begin=i;
                    }
                }
            }
        }
        return s.substring(begin,max+begin);
    }
}
