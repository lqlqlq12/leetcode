package leetcode75.Stack;

//394.字符串解码
/*给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。*/
public class DecodeString {
    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ) {
            if (Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
                i++;
                continue;
            } else {
                int times = 0, start, pair = 0;
                while (Character.isDigit(charArray[i])) {
                    times = times * 10 + (charArray[i] - '0');
                    i++;
                }
                i++;
                start = i;
                while (pair != 0 || charArray[i] != ']') {
                    if (charArray[i] == '[') {
                        pair++;
                    } else if (charArray[i] == ']') {
                        pair--;
                    }
                    i++;
                }
                String inner = decodeString(s.substring(start, i));
                for (int j = 0; j < times; j++) {
                    sb.append(inner);
                }
                i++;
            }
        }
        return sb.toString();
    }

    public void test() {
        decodeString("3[a2[c]]");
        decodeString("3[a2[c]]");
        decodeString("3[a2[c]]");
    }

    public static void main(String[] args) {
        new DecodeString().test();
    }
}
