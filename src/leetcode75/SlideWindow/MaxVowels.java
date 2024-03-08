package leetcode75.SlideWindow;

import java.util.HashMap;
import java.util.Map;

//1456.定长子串中元音的最大数目
/*给你字符串 s 和整数 k 。

请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

英文中的 元音字母 为（a, e, i, o, u）。*/
//思路:滑动窗口 好像不需要map
public class MaxVowels {
    public int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int max = 0, now;
        for (int i = 0; i < k; i++) {
            char c = charArray[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                max++;
            }
        }
        now = max;
        for (int i = 0; i < len - k; i++) {
            char head = charArray[i], end = charArray[i + k];
            if (head == 'a' || head == 'e' || head == 'i' || head == 'o' || head == 'u') {
                now--;
            }
            if (end == 'a' || end == 'e' || end == 'i' || end == 'o' || end == 'u') {
                now++;
            }
            max = Math.max(max, now);
        }
        return max;
    }
}
