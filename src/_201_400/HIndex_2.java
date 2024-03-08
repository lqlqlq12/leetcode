package _201_400;

//275.H指数II
/*给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。

计算并返回该研究者的 h 指数。

h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。

请你设计并实现对数时间复杂度的算法解决此问题。*/
//二分:初始左边界是0 右边界是n-1 第i篇论文 引用次数citations[i] 引用次数大于等于citations[i]的有count个
//count=n-i
//从左往右 count递减 citations[i]非强递增
//答案的左边:count>citations[i]
//答案的右边:count<citations[i]
//7 8 9 10 100
//1 2 9 10 100
//1 3 9 10
//5 8 9 10 100
//0 0 0 0 1  1
//0 0 0 0 0  0
//0 0 0 0 100 1
//0 3 3 3
public class HIndex_2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex_2().optimize(new int[]{0}));
    }

    //left,right  可取值:0-len len-i->[0,len] i->[0,len]
    //count=len-i
    //count>citations[i] count<citations[i]
    //[0]
    public int optimize(int[] citations) {
        int len = citations.length, left = 0, right = len;
        //left=right->
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = len - mid;
            if (count > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }
}
