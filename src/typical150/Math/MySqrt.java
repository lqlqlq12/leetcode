package typical150.Math;

//x的平方根
/*给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。*/
//二分
public class MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left < right) {
            int mid = left + 1 + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if ((long) mid * mid < x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
