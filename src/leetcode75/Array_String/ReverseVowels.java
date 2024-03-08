package leetcode75.Array_String;

//345.反转字符串中的元音字母
/*给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。*/
//思路:双指针
public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < right && !isVowel(charArray[left])) left++;
            while (left < right && !isVowel(charArray[right])) right--;
            char t = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = t;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
