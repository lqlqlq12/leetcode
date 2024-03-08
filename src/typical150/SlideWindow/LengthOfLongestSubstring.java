package typical150.SlideWindow;

import java.util.HashSet;
import java.util.Set;

//3.无重复字符的最长字串
/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度*/
//s 由英文字母、数字、符号和空格组成
//思路:滑动窗口
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length, re = 0;
        if (len == 0 || len == 1) {
            return len;
        }
        Set<Character> set = new HashSet<>();
        int left, right;
        for (left = 0, right = 0; right < len; ) {
            while (right < len && !set.contains(charArray[right])) {
                set.add(charArray[right++]);
            }
            if (right == len) {
                break;
            }
            re = Math.max(re, right - left);
            while (charArray[left] != charArray[right]) {
                set.remove(charArray[left++]);
            }
            set.remove(charArray[left++]);
        }
        re = Math.max(re, right - left);
        return re;
    }
}
