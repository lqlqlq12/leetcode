package _201_400;

//326.3的幂
/*给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x*/
/*你能不使用循环或者递归来完成本题吗？*/
//3进制: 0->0 1->1 2->2 3->0
//        00    01   10    00
//a表示高位 b表示低位
//a=0&&b=0 +1 -> a=0,b=1
//a=0&&b=1 +1 -> a=1,b=0
//a=1&&b=0 +1 -> a=0,b=0
//当b=0时 a无法正常异或 所以 a=(a^num)&b
//当a=1时 b无法正常异或 所以 b=(b^num)&~a
//3-> 11
//9-> 1001
//27-> 16+8+2+1 11011
//81-> 64+16+1  1010001
//官解 3^19%(n)==0?
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
