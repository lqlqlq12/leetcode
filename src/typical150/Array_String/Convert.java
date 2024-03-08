package typical150.Array_String;

import java.util.ArrayList;
import java.util.List;

//6.N字形转换
/*将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);*/
//思路 有几行就建几个list 然后直接构造 依次放到对应的行里
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> re = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            re.add(new StringBuilder());
        }
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int flag = 1;//1从上往下 -1反之
        for (int i = 0, row = 1; i < len; i++) {
            re.get(row - 1).append(charArray[i]);
            if (row == numRows || (i != 0 && row == 1)) {
                flag = -flag;
            }
            row += flag;
        }
        for (StringBuilder t : re) {
            sb.append(t);
        }
        return sb.toString();
    }
}
