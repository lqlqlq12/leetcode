package _1_200;

//43.字符串相乘
/*给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。*/
//10 1000 10000
public class Multiply {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] number1 = new int[len1];
        int[] number2 = new int[len2];
        int[] re = new int[len1 + len2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len1; i++) {
            number1[len1 - i - 1] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < len2; i++) {
            number2[len2 - i - 1] = num2.charAt(i) - '0';
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                re[i + j] += (number1[i] * number2[j]);
            }
        }
        for (int i = 0; i < len1 + len2 - 1; i++) {
            re[i + 1] += (re[i] / 10);
            re[i] %= 10;
            sb.append(re[i]);
        }
        if (re[len1 + len2 - 1] != 0) {
            sb.append(re[len1 + len2 - 1]);
        }
        return sb.reverse().toString();
    }
}
