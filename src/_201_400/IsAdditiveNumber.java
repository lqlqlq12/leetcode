package _201_400;

import org.junit.Test;

//306.累加数
/*累加数 是一个字符串，组成它的数字可以形成累加序列。

一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。

给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。

说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。*/
//思路:回溯? 是否是有效的 无非就是看第一个和第二个数是多少  第一个s[0:i]第二个[i+1:j] j<=len/3
//注意范围 long
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        long a = 0, b = 0, c = 0;
        for (int i = 0; i < len - 2; i++) {
            //a:[0:i] b[i+1:j]
            if (i == 1 && num.charAt(0) == '0') break;
            for (int j = i + 1; j < len - 1; j++) {
                if (Math.max(i + 1, j - i) > len - j - 1) {
                    break;
                }
                if (j == i + 2 && num.charAt(j - 1) == '0') {
                    break;
                }
                int index = j + 1;
                a = Long.parseLong(num.substring(0, i + 1));
                b = Long.parseLong(num.substring(i + 1, j + 1));
                while (index < len) {
                    c = a + b;
                    String next = String.valueOf(c);
                    if (index + next.length() <= len && next.equals(num.substring(index, index + next.length()))) {
                        a = b;
                        b = c;
                        index += next.length();
                    } else {
                        break;
                    }
                }
                if (index == len) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        isAdditiveNumber("0235813");
    }
}
