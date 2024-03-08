package _1_200;

//168.Excel表列名称
/*给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...*/
//26进制
//2进制 11
/*
 *11/2=5...1
 * 5/2=2...1
 * 2/2=1...0
 * 1/1=0...1
 * 所以11=1011
 * */
public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int mod = columnNumber % 26;
            columnNumber /= 26;
            sb.append((char) ('A' + mod));
        }
        return sb.reverse().toString();
    }
}
