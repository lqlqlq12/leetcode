package typical150.SlideWindow;

import java.util.HashMap;
import java.util.Map;

//76.最小覆盖子串
/*给你一个字符串 s 、一个字符串 t 。
返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。*/
//思路:滑动窗口ba 然后用valid表示和t的距离 就是差多少字符 hashMap的所有value都为0说明涵盖了
/*你能设计一个在 o(m+n) 时间内解决此问题的算法吗？*/
public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] charArray = s.toCharArray();
        int valid = map.size(), len = charArray.length;
        int minLeft = -1, minSize = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < len; ) {
            while (r < len && valid != 0) {
                if (map.containsKey(charArray[r])) {
                    int need = map.get(charArray[r]);
                    if (need == 1) {
                        valid--;
                    }
                    map.put(charArray[r], need - 1);
                }
                r++;
            }
            if (r == len + 1) {
                break;
            }
            while (valid == 0) {
                int size = r - l;
                if (size < minSize) {
                    minSize = size;
                    minLeft = l;
                }
                if (map.containsKey(charArray[l])) {
                    int need = map.get(charArray[l]);
                    if (need == 0) {
                        valid++;
                    }
                    map.put(charArray[l], need + 1);
                }
                l++;
            }
        }
        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minSize);
    }
}
