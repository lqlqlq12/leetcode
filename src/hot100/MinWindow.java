package hot100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//最小覆盖子串
/*给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。*/
//滑动窗口 l,r双指针,l不动,r右移,直到匹配,匹配后l右移压缩,更新最小值,直到不匹配,r又开始右移
public class MinWindow {
    Map<Character, Integer> target;
    Map<Character, Integer> now;

    public String minWindow(String s, String t) {
        target = new HashMap<>();
        now = new HashMap<>();
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        int minL = -1, minR = -1;
        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        for (; r < len; r++) {
            if (target.containsKey(s.charAt(r))) {
                now.put(s.charAt(r), now.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (isValid() && l <= r) {
                if (r - l + 1 < minLen) {
                    minL = l;
                    minR = r;
                    minLen = r - l + 1;
                }
                if (target.containsKey(s.charAt(l))) {
                    int remain = now.get(s.charAt(l)) - 1;
                    if (remain == 0) {
                        now.remove(s.charAt(l));
                    } else {
                        now.put(s.charAt(l), remain);
                    }

                }
                l++;
            }
        }
        return minL != -1 ? s.substring(minL, minR + 1) : "";
    }

    public boolean isValid() {
        for (Character key : target.keySet()) {
            if (target.get(key).compareTo(now.getOrDefault(key, 0)) > 0) {
                return false;
            }
        }
        return true;
    }

    //用map的满足条件的键值对比较
    public String minWindow_1(String s, String t) {
        target = new HashMap<>();
        now = new HashMap<>();
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        int minL = -1, minR = -1;
        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int valid = 0;
        for (; r < len; r++) {
            if (target.containsKey(s.charAt(r))) {
                int temp = now.getOrDefault(s.charAt(r), 0) + 1;
                now.put(s.charAt(r), temp);
                if (temp == target.get(s.charAt(r))) {
                    valid++;
                }
            }
            while (valid == target.size() && l <= r) {
                if (r - l + 1 < minLen) {
                    minL = l;
                    minR = r;
                    minLen = r - l + 1;
                }
                if (target.containsKey(s.charAt(l))) {
                    int remain = now.get(s.charAt(l)) - 1;
                    if (remain == 0) {
                        now.remove(s.charAt(l));
                    } else {
                        now.put(s.charAt(l), remain);
                    }
                    if (remain < target.get(s.charAt(l))) {
                        valid--;
                    }
                }
                l++;
            }
        }
        return minL != -1 ? s.substring(minL, minR + 1) : "";
    }

    //优化为一个map
    public String minWindow_2(String s, String t) {
        int sLength = s.length();
        char[] sCharArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int minL = -1, minLength = Integer.MAX_VALUE, valid = map.size();
        for (int l = 0, r = 0; r < sLength; r++) {
            if (map.containsKey(sCharArray[r])) {
                int need = map.get(sCharArray[r]) - 1;
                map.put(sCharArray[r], need);
                if (need == 0) {
                    valid--;
                }
            }
            while (valid == 0 && l <= r) {
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    minL = l;
                }
                if (map.containsKey(sCharArray[l])) {
                    int now = map.get(sCharArray[l]);
                    if (now == 0) {
                        valid++;
                    }
                    map.put(sCharArray[l], now + 1);
                }
                l++;
            }
        }
        return minL == -1 ? "" : s.substring(minL, minL + minLength);
    }
}
