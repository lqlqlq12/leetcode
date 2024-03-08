package _201_400;

import java.util.Map;
import java.util.TreeMap;

//352.将数据流变为多个不相交区间
/*给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。

实现 SummaryRanges 类：

SummaryRanges() 使用一个空数据流初始化对象。
void addNum(int val) 向数据流中加入整数 val 。
int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。*/
/*进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?*/
//官解:有序集合
//首先分类讨论 添加一个val有哪几种可能
//1.[l,r]+val-> val=r+1 [l,r+1]
//2.[l,r]+val-> val=l-1 [l-1,r]
//3.[l1,r1][l2,r2]+val r1+1=val,val+1r=l2 [l1,r2]
//4.val->[val,val]
//5.[l,r]+val->l<=val<=r [l,r]
//使用有序集合 TreeMap<Integer,Integer> key是l,value是r
public class SummaryRanges {
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
        map.put(-2, -2);
        map.put(10002, 10002);
    }

    public void addNum(int value) {
        Map.Entry<Integer, Integer> interval1 = map.floorEntry(value);
        Map.Entry<Integer, Integer> interval2 = map.ceilingEntry(value + 1);
        if (interval1.getValue() + 1 < value && interval2.getKey() - 1 > value) {
            map.put(value, value);
        } else if (interval1.getValue() + 1 == value && value + 1 == interval2.getKey()) {
            map.put(interval1.getKey(), interval2.getValue());
            map.remove(interval2.getKey());
        } else if (interval1.getValue() + 1 == value) {
            map.put(interval1.getKey(), value);
        } else if (interval2.getKey() == value + 1) {
            map.put(value, interval2.getValue());
            map.remove(interval2.getKey());
        }
    }

    public int[][] getIntervals() {
        int[][] re = new int[map.size() - 2][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == -2 || entry.getKey() == 10002)
                continue;
            re[index][0] = entry.getKey();
            re[index++][1] = entry.getValue();
        }
        return re;
    }
}
