package typical150.TwoPoint;

//125.验证回文串
/*如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

字母和数字都属于字母数字字符。

给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false */
//s 仅由可打印的 ASCII 字符组成
//思路:双指针吧
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().toCharArray();
        int len = charArray.length, left = 0, right = len - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(charArray[left]) && !Character.isDigit(charArray[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(charArray[right]) && !Character.isDigit(charArray[right])) {
                right--;
            }
            if (left < right && charArray[left] != charArray[right]) {
                return false;
            } else if (left < right) {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Character.isLetter('0'));
    }
}
