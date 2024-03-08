package _201_400;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//318.最大单词长度乘积
/*给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，

并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。*/
//思路:首先肯定遍历数组 确认每个单词都有哪些字符 然后遍历数组 在没有共同字符的两个数组的长度乘积中 选取最大值
//可以用位运算 一共a-z26个字符 用26个bit就可以表示一个单词出现了哪些字符 有共同字符的话 a&b!=0
public class MaxProduct {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int re = 0;
        for (String word : words) {
            int key = 0;
            for (char c : word.toCharArray()) {
                key |= (1 << (c - 'a'));
            }
            if (word.length() > map.getOrDefault(key, 0)) {
                map.put(key, word.length());
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key1 : keys) {
            for (Integer key2 : keys) {
                if ((key1 & key2) == 0) {
                    re = Math.max(re, map.get(key1) * map.get(key2));
                }
            }
        }
        return re;
    }
}
