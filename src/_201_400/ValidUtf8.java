package _201_400;

import org.junit.Test;

//393.UTF-8编码验证
/*给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。

UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：

对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。*/
//题目简单 但是细节有点多的
public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; ) {
            int first = getOneNumber(data[i]);
            if (first == 0) {
                i++;
            } else if (first > 4 || first == 1) return false;
            else {
                if (i + first > len) return false;
                for (int j = 1; j < first; j++) {
                    if (getOneNumber(data[j + i]) != 1) {
                        return false;
                    }
                }
                i += first;
            }
        }
        return true;
    }

    //获得第一个0之前有几个1
    public int getOneNumber(int number) {
        int t = (1 << 7), ans = 0;
        while (number >= t && number != 0) {
            ans++;
            number -= t;
            t >>= 1;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(230));
        System.out.println(Integer.toBinaryString(136));
        System.out.println(Integer.toBinaryString(145));
        validUtf8(new int[]{230, 136, 145});
    }
}
