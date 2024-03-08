package hot100;

import java.util.*;

//438.找到字符串中所有字母异位词
/*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。*/
//暴力解法: 滑动窗口,超时 优化:用一个临时的map存字串的字符及数量 然后就不超时了 再优化:只有26个字母,不用map 而用数组
//滑动窗口优化: 不用两个数组 改用一个数组即可,并记录窗口中和p中字母数量不同的字母数量differ differ为0说明都相同
public class FindAnagrams {

    Map<Character, Integer> target;
    Map<Character, Integer> source;

    public List<Integer> findAnagrams(String s, String p) {
        target = new HashMap<>();
        source = new HashMap<>();
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> re = new ArrayList<>();
        if (sLen < pLen) {
            return re;
        }
        for (int i = 0; i < pLen; i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
            source.put(s.charAt(i), source.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (isTarget()) {
            re.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            source.put(s.charAt(i), source.get(s.charAt(i)) - 1);
            source.put(s.charAt(i + pLen), source.getOrDefault(s.charAt(i + pLen), 0) + 1);
            if (isTarget()) {
                re.add(i + 1);
            }
        }
        return re;
    }

    public boolean isTarget() {
        for (Character c : target.keySet()) {
            if (!source.containsKey(c) || !source.get(c).equals(target.get(c)))
                return false;
        }
        return true;
    }

    public List<Integer> withArray(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> re = new ArrayList<>();
        if (sLen < pLen) {
            return re;
        }
        int[] source = new int[26];
        int[] target = new int[26];
        for (int i = 0; i < pLen; i++) {
            source[s.charAt(i) - 'a']++;
            target[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(source, target)) {
            re.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            source[s.charAt(i) - 'a']--;
            source[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(source, target)) {
                re.add(i + 1);
            }
        }
        return re;
    }

    public List<Integer> withOneArray(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> re = new ArrayList<>();
        if (sLen < pLen) {
            return re;
        }
        int[] count = new int[26];
        for (int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']--;
            count[s.charAt(i) - 'a']++;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                differ++;
            }
        }
        if (differ == 0) {
            re.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            int t = --count[s.charAt(i) - 'a'];
            if (t == 0) {
                differ--;
            }
            if (t == -1) {
                differ++;
            }
            int m = ++count[s.charAt(i + pLen) - 'a'];
            if (m == 0) {
                differ--;
            }
            if (m == 1) {
                differ++;
            }
            if (differ == 0) {
                re.add(i + 1);
            }
        }
        return re;
    }
}
