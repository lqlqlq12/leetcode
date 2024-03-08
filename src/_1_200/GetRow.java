package _1_200;

import java.util.ArrayList;
import java.util.List;

//119.杨辉三角II
/*给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。*/
/*你可以优化你的算法到 O(rowIndex) 空间复杂度吗？*/
/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
* */
//rowIndex最大33
//用二项式(x+y)^n的公式C(n,m)=C(n,m-1)*(n-m+1)/m
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> re = new ArrayList<>();
        re.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            re.add((int) ((long) re.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return re;
    }
}
