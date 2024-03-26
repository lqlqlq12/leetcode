package _201_400;

import org.junit.Test;

//400.第N位数字
/*给你一个整数 n ，请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位上的数字。*/
//1-9:1*9=9位
//10-99:2*90=180
//100-999:3*900
//10->1 11->0,
//12->1,13->1,
//14->1 15->2
public class FindNthDigit {
    public int findNthDigit(int n) {
        int digit = 1, count = 9, re, pre = 0;
        while (pre + (long) digit * count < n) {
            pre += digit * count;
            digit++;
            count *= 10;
        }
        n -= pre;
        re = count / 9;
        re += (n - 1) / digit;
        return getDigit(re, (n - 1) % digit);
    }

    public int getDigit(int number, int digit) {
        return Integer.parseInt(String.valueOf(number).substring(digit, digit + 1));
    }

    @Test
    public void test() {
//        findNthDigit(1000000000);
        findNthDigit(11);
    }


}
