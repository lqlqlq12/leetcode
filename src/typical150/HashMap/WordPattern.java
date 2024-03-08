package typical150.HashMap;

import java.util.HashMap;
import java.util.Map;

//单词规律
/*给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。*/
/*输入: pattern = "abba", s = "dog cat cat dog"
输出: true*/
/*输入:pattern = "abba", s = "dog cat cat fish"
输出: false*/
//基本解:两个hashmap 做双向匹配
//巧解:用两个hashmap 存第一次出现的位置,每个不同的字母和单词第一次出现的位置都是唯一的,用这个唯一性判断是否一致 但是好像更慢了
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> chToWord = new HashMap<>();
        Map<String, Character> wordToCh = new HashMap<>();
        String[] words = s.split(" ");
        char[] chs = pattern.toCharArray();
        //注意有坑:二者的长度可能不一致！
        if (words.length != chs.length) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            if (!wordToCh.containsKey(words[i])) {
                if (chToWord.containsKey(chs[i])) {
                    return false;
                }
                wordToCh.put(words[i], chs[i]);
                chToWord.put(chs[i], words[i]);
            } else {
                if (wordToCh.get(words[i]) != chs[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean twoMap(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chs = pattern.toCharArray();
        if (words.length != chs.length) {
            return false;
        }
        Map<String, Integer> wordFirstIndex = new HashMap<>();
        Map<Character, Integer> chFirstIndex = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if (!wordFirstIndex.containsKey(words[i]) && !chFirstIndex.containsKey(chs[i])) {
                wordFirstIndex.put(words[i], i);
                chFirstIndex.put(chs[i], i);
            }
            //两个map都包含,或者一个有一个没有
            else{
                if(!wordFirstIndex.getOrDefault(words[i],-1).equals(chFirstIndex.getOrDefault(chs[i],-1))){
                    return false;
                }
            }
        }
        return true;
    }
}
