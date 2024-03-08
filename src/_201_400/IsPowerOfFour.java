package _201_400;

//342.4的幂
/*给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x*/
//4^x=2^(2x) 100000... 后面有偶数个0 所以只有一个1 并且1出现在奇数位 所以x&(1010101010101...)==x
//100 10000
public class IsPowerOfFour {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & (0x55555555)) == n;
    }
}
