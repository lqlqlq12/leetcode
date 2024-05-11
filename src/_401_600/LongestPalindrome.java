package _401_600;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//409.最长回文串
/*给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。

在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。*/
//思路 就是统计总个数是偶数的有多少个 然后奇数的加上一个减一后的结果 最后加上一个1
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int x = 0, y = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 0) {
                x += value;
            } else {
                y += value - 1;
            }
        }
        return x + y + (x != s.length() ? 1 : 0);
    }

    @Test
    public void test() {
        longestPalindrome("abccccdd");
    }
}
