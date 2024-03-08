package _201_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//350.两个数组的交集II
/*给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。*/
/*如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？*/
//还是直接重拳出击
//思路:最简单的肯定直接遍历两个用Map记录 然后在遍历Map
//可以先遍历一个 然后记录Map 然后遍历第二个时 将map的value-1 减到0就不能再减了
//如果有序 使用双指针 相同时 同时移动
//不同时 移动小的元素的指针
//在磁盘上就不可以使用排序了
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> reList = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            int val = map.getOrDefault(i, 0);
            if (val >= 1) {
                reList.add(i);
                map.put(i, val - 1);
            }
        }
        int[] re = new int[reList.size()];
        int index = 0;
        for (Integer i : reList) {
            re[index++] = i;
        }
        return re;
    }
}
