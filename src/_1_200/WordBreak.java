package _1_200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//140.单词拆分II
/*给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，

使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。

注意：词典中的同一个单词可能在分段中被重复使用多次。*/
//思路:回溯吧
public class WordBreak {
    List<String> re;
    Set<String> wordSet;
    String s;
    int maxLen;

    public List<String> wordBreak(String s, List<String> wordDict) {
        re = new ArrayList<>();
        wordSet = new HashSet<>(wordDict);
        maxLen = 0;
        this.s = s;
        for (String string : wordSet) {
            maxLen = Math.max(maxLen, string.length());
        }
        backTrack(0, new StringBuilder());
        return re;
    }

    public void backTrack(int index, StringBuilder sb) {
        if (index == s.length()) {
            re.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = 1; i <= maxLen && index + i <= s.length(); i++) {
            if (wordSet.contains(s.substring(index, index + i))) {
                sb.append(s, index, index + i).append(" ");
                backTrack(index + i, sb);
                sb.delete(sb.length() - i - 1, sb.length());
            }
        }
    }

    //["cat","cats","and","sand","dog"]
    public void test() {
        List<String> wordList = new ArrayList<>();
        wordList.add("cat");
        wordList.add("cats");
        wordList.add("and");
        wordList.add("sand");
        wordList.add("dog");
        wordBreak("catsanddog", wordList);
    }

    public static void main(String[] args) {
        new WordBreak().test();
    }
}
