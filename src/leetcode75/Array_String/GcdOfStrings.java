package leetcode75.Array_String;

//1071.字符串的最大公因子
/*对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。

给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。*/
public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        String T = str1.substring(0, gcd(len1, len2));
        int tLen = T.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        char[] t = T.toCharArray();
        for (int i = 0; i < len1; i++) {
            if (arr1[i] != t[i % tLen]) {
                return "";
            }
        }
        for (int i = 0; i < len2; i++) {
            if (arr2[i] != t[i % tLen]) {
                return "";
            }
        }
        return T;
    }

    public int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }
}
