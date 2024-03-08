package _201_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//217.存在重复元素
/*给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。*/
//思路:直接hashmap
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int contain = map.getOrDefault(num, 0);
            if (contain == 1) return true;
            map.put(num, contain + 1);
        }
        return false;
    }

    public boolean optimize(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
