package _201_400;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//258.各位相加
/*给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。*/
/*你可以不使用循环或者递归，在 O(1) 时间复杂度内解决这个问题吗？*/
public class AddDigits {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    //num和num各位求和 %9的结果都一样 数学结论
    public int optimize(int num) {
        return (num - 1) % 9 + 1;
    }
}
