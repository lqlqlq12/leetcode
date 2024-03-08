package typical150.Math;

//阶乘后的零
/*给定一个整数 n ，返回 n! 结果中尾随零的数量。

提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1*/
/*你可以设计并实现对数时间复杂度的算法来解决此问题吗？*/
//我真笨 0的个数=因数中10的个数=2*5的个数 也就是2和5中个数比较小的个数 因为5的个数不会大于2 所以就是5的个数 所以O(n)
//优化方法 太巧妙了 我是sb

public class TrailingZeroes {
    public int trailingZeros(int n) {
        int re = 0;
        for (int i = 5; i <= n; i += 5) {
            int x = i;
            while (x % 5 == 0) {
                re++;
                i /= 5;
            }
        }
        return re;
    }

    public int func(int n) {
        int re = 0;
        while (n != 0) {
            n /= 5;
            re += n;
        }
        return re;
    }
}
