package _201_400;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//至少有k个重复字符的最长子串
/*给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。

如果不存在这样的子字符串，则返回 0。*/
//思路:先用动规dp[i][j] 元素是一个26的数组 记录s[i:j]的字母的出现情况
//然后把次数不足k的字符作为分割点 因为结果中不能出现总次数都不超过k的字母
//超时了 感觉是动规的问题 不用动规
public class LongestSubstring {
    String s;

    public int longestSubstring(String s, int k) {
        if (k == 1) return s.length();
        this.s = s;
        int len = s.length();
        return getMaxLenSubstring(0, len - 1, k);
    }

    public int getMaxLenSubstring(int left, int right, int k) {
        if (left > right) return 0;
        int[] counts = new int[26];
        for (int i = left; i <= right; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        Set<Integer> lessThanK = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0 && counts[i] < k) {
                lessThanK.add(i);
            }
        }
        if (lessThanK.isEmpty()) {
            return right - left + 1;
        }
        int re = 0;
        int last = 0;
        for (int i = left; i <= right; i++) {
            if (lessThanK.contains(s.charAt(i) - 'a')) {
                int t = getMaxLenSubstring(last, i - 1, k);
                if (t > re) re = t;
                last = i + 1;
            }

        }
        int t = getMaxLenSubstring(last, right, k);
        if (t > re) re = t;
        return re;
    }

    @Test
    public void test() {
        longestSubstring("aaaaaaaaabbbcccccddddd", 5);
    }

}
