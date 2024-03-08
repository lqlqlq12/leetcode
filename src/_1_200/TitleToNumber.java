package _1_200;

//171.Excel表列序号
/*给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...*/
public class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        int re = 0;
        for (char c : columnTitle.toCharArray()) {
            re = re * 26 + (c - 'A' + 1);
        }
        return re;
    }
}
