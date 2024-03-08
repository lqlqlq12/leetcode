package typical150.HashMap;

import java.util.HashMap;
import java.util.Map;

//219.存在重复元素II
/*给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。*/
//哈希表呗
//思路:一直删除和插入要O(logn) 不删除 直接记录上一次出现的位置
public class ContainsNearbyDuplicate_2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer lastIndex = map.getOrDefault(nums[i], -k - 1);
            if (i - lastIndex <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
