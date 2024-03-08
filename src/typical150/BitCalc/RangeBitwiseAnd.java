package typical150.BitCalc;

//201.数字范围按位与
/*给你两个整数 left 和 right ，表示区间 [left, right] ，
返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。*/
//本质就是求m和n的公共前缀
//number&(number-1) number最右边的1会被置0
//方法一:位移 当m<n时 m和n都向右移动 直到m=n 此时在向左移动到原来的位置 就得到了公共前缀 O(logn)
//方法二:将right最右边的1不断置0 直到left==right 此时就得到了结果 O(logn) 但是次数会更少
public class RangeBitwiseAnd {
    //方法一
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    //方法二
    public int optimize(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }
}
