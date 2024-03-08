package leetcode75.HashMap_Set;

import java.util.Arrays;

//1657.确定两个字符串是否相近
/*如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：

操作 1：交换任意两个 现有 字符。
例如，abcde -> aecdb
操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
你可以根据需要对任意一个字符串多次使用这两种操作。

给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。*/
//毫无思路
//有了操作1 可以将字符串的字符顺序变成任意的 所以只要字符及对应的次数相等 就接近
//有了操作2 只要字符的个数的数字序列相等就行
//综上 就是看两个数组的组成是否相等
//需要注意的是 要出现过的字符才可以进行操作 所以如果word1的某个字符没出现 word2也要没有出现
public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        int[] c1 = new int[26], c2 = new int[26];
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        for (char c : w1) {
            c1[c - 'a']++;
        }
        for (char c : w2) {
            c2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((c1[i] > 0 && c2[i] == 0) || (c1[i] == 0 && c2[i] > 0)) return false;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
