package _1_200;

//29.两数相除
/*给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。

整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。

返回被除数 dividend 除以除数 divisor 得到的 商 。

注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。*/
//我觉得应该用位运算 或者用数组存储数字 然后模拟除法
//官解用二分 不懂 细节:题目要求不要用long了 那负数变正数有可能会溢出 就把两个数都变成负数就好了
//二分: Y/X 求解Z 所以有 Z*X>=Y>=(Z+1)*X 注意是负数
//不能用乘法 用[快速乘] 通过加法实现乘法 [快速幂]通过乘法实现幂
//放弃了 快速加 不会
public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        int flag = 1;
        long end = dividend, sor = divisor, re = 0;
        if (end < 0) {
            end = -end;
            flag *= -1;
        }
        if (sor < 0) {
            sor = -sor;
            flag *= -1;
        }
        //10:1010 3:11 +2
        //4:100 3:11 +1
        while (end >= sor) {
            int t = 1;
            long temp = sor;
            while (end > (temp << 1)) {
                temp <<= 1;
                t <<= 1;
            }
            end -= temp;
            re += t;
        }
        re *= flag;
        if (re < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (re > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) re;
    }


}
