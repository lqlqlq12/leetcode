package typical150.HashMap;

import java.util.HashSet;
import java.util.Set;

//128.最长连续序列
/*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。*/
//思路:一下子没想出来 将元素放到集合里 然后对于一个序列 [i,i+1,i+2.....j]我们应该从i开始往后遍历 遍历到的元素从set中移除
//如果 从i以外的开始遍历 则会重复判断 非常蠢
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int re = 1;
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < len; i++) {
            //前面还有元素 则跳过
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int length = 0;
            for (int j = nums[i]; set.contains(j); length++, j++) {
                set.remove(j);
            }
            re = Math.max(re, length);
        }
        return re;
    }
}
