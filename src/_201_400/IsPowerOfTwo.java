package _201_400;

//231.2的幂
/*给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。*/
//思路:如果是n是2的幂次方 那二进制应该是 1000000... 可以不断右移 在值为1之前 最右位都是0
//也可以不要用位运算 不断除2 不为奇数就行
//官解 n&(n-1)可以将最低位的1变成0 所以n&(n-1)==0  就说明n是2的幂次方
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 == 1) return false;
            n /= 2;
        }
        return true;
    }

    public boolean optimize(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
