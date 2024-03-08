package _201_400;

//233.数字1的个数
/*给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。*/
//0 1 2 3 4 5 ... n
//官解:假设n是个3位数 就分别计算个位、十位、百位上1的出现个数
//456 个位1:46 十位1:5*10=50 百位1:1*100=100 所以196
//415 个位1:42 十位:4*10+6=46 百位:100 所以188
//505 个位1:51 十位5*10=50 百位100 201
//2234 2130
//官解的digit用了long 注意范围
public class CountDigitOne {
    public int countDigitOne(int n) {
        int digit = 1, re = 0;
        while (digit <= n) {
            int before = n / (digit * 10);
            int after = n % digit;
            int mid = (n / digit) % 10;
            if (mid == 0) {
                re += before * digit;
            } else if (mid == 1) {
                re += before * digit + after + 1;
            } else {
                re += (before + 1) * digit;
            }
            digit *= 10;
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(new CountDigitOne().countDigitOne(505));
    }
}
