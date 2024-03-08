package _201_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//349.两个数组的交集
/*给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。*/
//送分题 直接重拳出击
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> list = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
            }
        }
        int[] re = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            re[index++] = i;
        }
        return re;
    }
}
