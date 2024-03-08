package leetcode75.Array_String;

//151.反转字符串中的单词
/*给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。*/
/*进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。*/
public class ReverseWords {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        char[] re = new char[len];
        int index = 0, left, right;
        for (left = len - 1, right = left; left >= 0; left--) {
            if (charArray[left] == ' ') {
                if (left == right) {
                    right--;
                } else {
                    for (int j = left + 1; j <= right; j++) {
                        re[index++] = charArray[j];
                    }
                    re[index++] = ' ';
                    right = left - 1;
                }
            }
        }
        if (charArray[0] != ' ') {
            for (int i = 0; i <= right; i++) {
                re[index++] = charArray[i];
            }
        }
        if (re[index - 1] == ' ') {
            index--;
        }
        return new String(re, 0, index);
    }
}

