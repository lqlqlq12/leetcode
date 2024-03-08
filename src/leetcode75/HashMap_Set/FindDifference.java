package leetcode75.HashMap_Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//2215.找出两数组的不同
/*给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：

answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
注意：列表中的整数可以按 任意 顺序返回。*/
//思路:用集合,但是优点慢
public class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (Integer i : set1) {
            if (!set2.contains(i)) {
                l1.add(i);
            }
        }
        for (Integer i : set2) {
            if (!set1.contains(i)) {
                l2.add(i);
            }
        }
        re.add(l1);
        re.add(l2);
        return re;
    }
}
