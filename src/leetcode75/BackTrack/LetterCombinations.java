package leetcode75.BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterInputStream;

//17.电话号码的字母组合
/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。*/
//思路:很简单的回溯
public class LetterCombinations {
    Map<Character, char[]> map;
    List<String> re;
    char[] t;
    int len;

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        re = new ArrayList<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        len = digits.length();
        if (len == 0) {
            return re;
        }
        t = new char[len];
        backTrack(digits.toCharArray(), 0);
        return re;
    }

    public void backTrack(char[] s, int index) {
        if (index == s.length) {
            re.add(new String(t));
            return;
        }
        for (char c : map.get(s[index])) {
            t[index] = c;
            backTrack(s, index + 1);
        }
    }
}
