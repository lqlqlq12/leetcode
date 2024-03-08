package _201_400;

import java.util.Arrays;

//214.最短回文串
/*给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。*/
//思路:只能在字符串的前面添加字符 所以s[0,1,2,3...n-1] 假设s[0:i]是从0开始的最长的回文串 那就添加s[i+1:n-1]的字符
//则还需添加的字符是最少的 得到的回文串也是最短的
//思路:用双指针
//官解:使用KMP算法 因为s[0:i]是回文串 所以s与s'匹配 当遍历到s'的最后一个元素时 s肯定遍历到i
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = charArray.length;
        for (int i = len - 1; i >= 0; i--) {
            int left = 0, right = i;
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    break;
                }
                left++;
                right--;
            }
            if (left >= right) {
                if (i < len - 1) {
                    sb.append(s.substring(i + 1));
                    return sb.reverse().append(s).toString();
                } else {
                    return s;
                }
            }
        }
        return "";
    }

    public String optimize(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int[] next = new int[len];
        Arrays.fill(next, -1);
        for (int i = 1; i < len; i++) {
            int j = next[i - 1];
            while (j != -1 && charArray[j + 1] != charArray[i]) {
                j = next[j];
            }
            if (charArray[j + 1] == charArray[i]) {
                next[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = len - 1; i >= 0; i--) {
            while (best != -1 && charArray[i] != charArray[best + 1]) {
                best = next[best];
            }
            if (charArray[i] == charArray[best + 1]) {
                best++;
            }
        }
        if (best == len - 1) return s;
        return new StringBuilder(s.substring(best + 1)).reverse().append(s).toString();
    }
}
