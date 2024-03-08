package leetcode75.Array_String;

//1768.交替合并字符串
/*给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，
就将多出来的字母追加到合并后字符串的末尾。

返回 合并后的字符串 。*/
//额 这种题有啥意义
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length(), min = Math.min(len1, len2);
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();

        char[] re = new char[len1 + len2];
        for (int i = 0; i < min; i++) {
            re[2 * i] = w1[i];
            re[2 * i + 1] = w2[i];
        }
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++) {
                re[2 * min + i] = w2[min + i];
            }
        } else {
            for (int i = 0; i < len1 - len2; i++) {
                re[2 * min + i] = w1[min + i];
            }
        }
        return new String(re);
    }
}
