package typical150.Math;

//Pow(x, n)
/*实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
n 是一个整数
要么 x 不为零，要么 n > 0 。*/
//快速幂算法,递归或迭代
//递归空间复杂度O(n) 迭代空间复杂度O(1)
public class myPow {
    public double myPow(double x, int n) {
        if (n > 0) {
            return recursion(x, (long) n);
        } else {
            return 1.0 / recursion(x, -(long) n);
        }
    }

    public double recursion(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = recursion(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public double ite(double x, int n) {
        if (n < 0) {
            return 1.0 / iteration(x, -(long) n);
        } else {
            return iteration(x, n);
        }
    }

    public double iteration(double x, long n) {
        double re = 1.0;
        double contribute_x = x;
        while (n > 0) {
            if (n % 2 == 1) {
                re *= contribute_x;
            }
            contribute_x *= contribute_x;
            n /= 2;
        }
        return re;

    }


}
