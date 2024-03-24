package WeekContest._390;

import org.junit.Test;

import java.util.*;

//100268.
/*给你两个字符串数组 wordsContainer 和 wordsQuery 。

对于每个 wordsQuery[i] ，你需要从 wordsContainer 中找到一个与 wordsQuery[i] 有 最长公共后缀 的字符串。如果 wordsContainer 中有两个或者更多字符串有最长公共后缀，那么答案为长度 最短 的。如果有超过两个字符串有 相同 最短长度，那么答案为它们在 wordsContainer 中出现 更早 的一个。

请你返回一个整数数组 ans ，其中 ans[i]是 wordsContainer中与 wordsQuery[i] 有 最长公共后缀 字符串的下标。*/
public class StringIndices {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int len = wordsQuery.length;
        int[] re = new int[len];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < wordsContainer.length; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < len; j++) {
                int t = maxLen(wordsContainer[i], wordsQuery[j]);
                map.get(i).add(t);
            }
        }

        for (int i = 0; i < len; i++) {
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int j = 0; j < wordsContainer.length; j++) {
                int t = map.get(j).get(i);
                if (max < t) {
                    max = t;
                    index = j;
                } else if (max == t) {
                    if (wordsContainer[index].length() > wordsContainer[j].length()) {
                        index = j;
                    }
                }
            }
            re[i] = index;
        }
        return re;
    }

    public int maxLen(String s, String t) {
        int re = 0;
        for (int i = 0; i < t.length() && i < s.length(); i++, re++) {
            if (s.charAt(s.length() - i - 1) != t.charAt(t.length() - i - 1)) {
                return re;
            }
        }
        return re;
    }

    @Test
    public void test() {
        int[] ints = stringIndices(new String[]{"abcd", "bcd", "xbcd"}, new String[]{"cd", "bcd", "xyz"});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
