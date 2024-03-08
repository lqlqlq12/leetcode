package typical150.BitCalc;

//67.二进制求和
/*给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和*/
/*a 和 b 仅由字符 '0' 或 '1' 组成
字符串如果不是 "0" ，就不含前导零*/
public class AddBinary {
    public String addBinary(String a, String b) {
        char[] aBits = a.toCharArray(), bBits = b.toCharArray();
        int aLen = aBits.length, bLen = bBits.length, n = Math.max(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            if (i < aLen && aBits[aLen - i - 1] == '1') carry += 1;
            if (i < bLen && bBits[bLen - i - 1] == '1') carry += 1;
            sb.append((char) ('0' + carry % 2));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    //位运算
    public String optimize(String a, String b) {
        int x = Integer.parseInt(a, 2), y = Integer.parseInt(b, 2);
        int answer = 0, carry = 0;
        while (y != 0) {
            answer = x ^ y;
            carry = (x & y) << 1;
            x = answer;
            y = carry;
        }
        return Integer.toBinaryString(x);
    }
}
