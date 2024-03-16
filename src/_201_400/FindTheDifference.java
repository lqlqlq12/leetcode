package _201_400;

import java.util.HashMap;
import java.util.Map;

//389.找不同
/*给定两个字符串 s 和 t ，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。*/
//直接HashMap重拳出击 或者排序 然后二分 直接遍历O(n+m) 排序O(mlog(m)+nlog(n)+log(m+n))
//官解 用位运算 因为其他都是偶数 只会有一个奇数 位运算O(m+n)
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] == -1) {
                return c;
            }
        }
        return ' ';
    }

    public char bitCalc(String s, String t) {
        int re = 0;
        for (char c : s.toCharArray()) {
            re ^= c;
        }
        for (char c : t.toCharArray()) {
            re ^= c;
        }
        return (char) re;
    }
}
