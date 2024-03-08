package hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//单词拆分
/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用*/
//回溯 超时
//动态规划 dp[i] s[0:i-1]是否可以被分割 dp[j]==true&&wordDict.contains(s.substring(j,i))->dp[i]=true
//动规中从长的字典单词开始比较,可以减少比较次数和更快得到结果
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.isEmpty()){
            return true;
        }
        for(int i=0;i<s.length();i++){
            for (String string : wordDict) {
                if(s.startsWith(string)){
                    if(wordBreak(s.substring(s.indexOf(string)+string.length()),wordDict))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean dynamicProgramming(String s,List<String> wordDict) {
        Set<String> set=new HashSet<>();
        int maxL=-1;
        for (String word : wordDict) {
            set.add(word);
            maxL=Math.max(maxL,word.length());
        }
        if (s == null || s.isEmpty()) {
            return true;
        }
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for(int i=1;i<=length;i++){
            for(int j=maxL;j>=0;j--){
                if(i-j>=0&&dp[i-j]&&set.contains(s.substring(i-j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[length];
    }

}
