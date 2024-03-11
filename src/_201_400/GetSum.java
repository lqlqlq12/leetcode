package _201_400;

import org.junit.Test;

//371.两整数之和
/*给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。*/
//a,b[-1000,1000]
//位运算? 看了官解的 感觉我写了一坨大的
public class GetSum {
    //下面这个好像无法处理负数
    public int getSum(int a, int b) {
        int re = 0, count = 0;
        int remain = 0;
        while (a != 0 || b != 0) {
            int x = a & 1, y = b & 1;
            int t = ((x ^ y) ^ remain) << count;
            if (x == 0 && y == 0) {
                remain = 0;
            } else if (x == 0) {
                remain &= y;
            } else if (y == 0) {
                remain &= x;
            } else {
                remain = 1;
            }
            re |= t;
            a >>>= 1;
            b >>>= 1;
            count++;
        }
        if (remain != 0 && count < 32) {
            re |= (remain << count);
        }
        return re;
    }

    public int optimize(int a, int b) {
        int carry = 0;
        while (b != 0) {
            carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }

    @Test
    public void test() {
        System.out.println(getSum(-1, 1));
        String binaryString = Integer.toBinaryString(-1);
        System.out.println(binaryString);
    }
}
