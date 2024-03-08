package typical150.Array_String;

import java.util.Arrays;
import java.util.Comparator;

//H指数
/*给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。

根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。*/
//思路 先排序 然后从大到小遍历 第一次右遍历的个数>当前的引用数 太低级了 时间O(nlogn) 空间O(logn)
//方法二:也是low bee方法 记录每个每一个次数的论文有多少 超过len次数的当作len 空间换时间 时间O(n) 空间O(n)
//方法三:二分...根本想不到二分 目标:找到一个尽可能大的number 使得count(number)>=number 时间(nlogn) 空间O(1)
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            count++;
            if (count > citations[i]) {
                return count - 1;
            }
        }
        return count;
    }

    public int method_2(int[] citations) {
        int len = citations.length;
        int[] numbers = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                numbers[len]++;
            } else {
                numbers[citations[i]]++;
            }
        }
        for (int i = len, count = 0; i >= 0; i--) {
            count += numbers[i];
            if (count >= i) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] citations) {
        int len = citations.length;
        int left = 0, right = len;
        int re = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }
            if (count < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                re = mid;
            }
        }
        return re;
    }
}
