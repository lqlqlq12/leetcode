package leetcode75.Bit_Calc;

//1318.或运算的最小翻转次数
/*给你三个正整数 a、b 和 c。

你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。

「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。*/
//思路:对最后一位进行操作 然后右移
// 1000 0011 0101
public class MinFlips {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            //最后一位是0
            if (c % 2 == 0) {
                if (a % 2 != 0) {
                    count++;
                }
                if (b % 2 != 0) {
                    count++;
                }
            } else {
                if (a % 2 == 0 && b % 2 == 0) {
                    count++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        new MinFlips().minFlips(8, 3, 5);
    }
}
