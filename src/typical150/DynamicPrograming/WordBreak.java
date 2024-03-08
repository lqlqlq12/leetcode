package typical150.DynamicPrograming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//139.单词拆分
/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。*/
//动规 dp[i] 表示 s[0:i-1]可以不可以被表示  dp[j]=true
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int strLen = s.length(), dictLen = wordDict.size();
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for (int i = 0; i < dictLen; i++) {
            wordSet.add(wordDict.get(i));
            maxLen = Math.max(maxLen, wordDict.get(i).length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < strLen; i++) {
            //j是单词长度
            for (int j = Math.min(maxLen, i + 1); j >= 0; j--) {
                if (wordSet.contains(s.substring(i - j + 1, i + 1)) && dp[i + 1 - j]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[strLen];
    }
}
