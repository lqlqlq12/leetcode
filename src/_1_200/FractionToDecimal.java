package _1_200;

import java.util.HashMap;
import java.util.Map;

//166.分数到小数
/*给定两个整数，分别表示分数的分子 n1 和分母 n2，以 字符串形式返回小数 。

如果小数部分为循环小数，则将循环的部分括在括号内。

如果存在多个答案，只需返回 任意一个 。

对于所有给定的输入，保证 答案字符串的长度小于 104 。*/
//模拟除法 用一个hashMap来保存除数及结果 如果除数重复出现 说明有循环
//用long 注意范围 正负 以及0
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long n1 = numerator, n2 = denominator;
        StringBuilder sb = new StringBuilder(), tail = new StringBuilder();
        int flag = 1;
        if (n1 < 0) {
            n1 = -n1;
            flag *= -1;
        }
        if (n2 < 0) {
            n2 = -n2;
            flag *= -1;
        }
        if (flag == -1 && n1 != 0) {
            sb.append("-");
        }
        long val = n1 / n2;
        if (val * n2 == n1) {
            return sb.append(val).toString();
        } else {
            sb.append(val).append(".");
        }
        n1 -= val * n2;
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        while (n1 != 0) {
            long t = n1;
            if (map.containsKey(t)) {
                int start = map.get(t);
                return sb.append(tail, 0, start).append("(").append(tail, start, tail.length()).append(")").toString();
            } else {
                map.put(t, index++);
            }
            n1 *= 10;
            tail.append(n1 / n2);
            n1 %= n2;
        }
        return sb.append(tail).toString();
    }

    public void test() {
        System.out.println(fractionToDecimal(-2147483648, 1));
    }

    public static void main(String[] args) {
        new FractionToDecimal().test();
    }
}
