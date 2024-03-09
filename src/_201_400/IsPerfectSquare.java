package _201_400;

//367.有效的完全平方数
/*给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。

完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。

不能使用任何内置的库函数，如  sqrt */
//先重拳出击 然后再看官解的巧解
//直接一个暴力for 用二分吧 二分更快
public class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long multi = (long) mid * mid;
            if (multi == num) {
                return true;
            }
            if (multi < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
