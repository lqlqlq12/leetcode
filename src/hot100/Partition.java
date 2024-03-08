package hot100;

import java.util.ArrayList;
import java.util.List;

//分割回文串
/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。*/
//先用动态规划dp[i][j],[i,i+1...j]是否是回文串
//回溯
public class Partition {
    static int[][] dp;
    static List<List<String>> ans=new ArrayList<>();

    public static void main(String[] args) {
        partition("a");
    }


    public static List<List<String>> partition(String s) {
        List<List<String>> re=new ArrayList<>();
        int length=s.length();
        dp=new int[length][length];
        char[] charArray = s.toCharArray();
        for(int i=0;i<length;i++){
            dp[i][i]=1;
        }
        //L是回文串的长度
        for(int L=2;L<=length;L++){
            //起始坐标
            for(int i=0;i<length;i++){
                //终止坐标
                int j=i+L-1;
                if(j>=length)
                    break;
                if(charArray[i]!=charArray[j])
                    dp[i][j]=0;
                else{
                    if(L<=3){
                        dp[i][j]=1;
                    }
                    else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        dfs(s,new ArrayList<String>(),0,s.length()-1);
        for (List<String> an : ans) {
            for (String string : an) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
        return ans;
    }
    
    //获取一个字符串的全部切割方法
    public static void dfs(String s,List<String> t,int begin,int end){
        if(begin==s.length()){
            ans.add(new ArrayList<String>(t));
            return;
        }
        for(int i=begin;i<=end;i++){
            if(dp[begin][i]==1){
                t.add(s.substring(begin,i+1));
                dfs(s,t,i+1,end);
                t.remove(t.size()-1);
            }
        }
    }
    
}
