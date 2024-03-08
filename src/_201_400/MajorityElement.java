package _201_400;

import java.util.ArrayList;
import java.util.List;

//229.多数元素II
/*给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。*/
//尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
//最笨的方法:遍历一遍 然后用一个HashMap记录 超过n/3的就加到结果集里
//之前的摩尔投票法用于超过n/2的
//思路:超过n/2的元素只能有1个
//超过n/3的元素不会超过2个 所以就维护两个投票对象就可以
// a b c c
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> re = new ArrayList<>();
        int len = nums.length;
        if (len == 1) {
            re.add(nums[0]);
            return re;
        }
        int a = 0, b = 0;
        int countA = 0, countB = 0;
        for (int i = 0; i < len; i++) {
            if (countA > 0 && a == nums[i]) {
                countA++;
            } else if (countB > 0 && b == nums[i]) {
                countB++;
            } else if (countA == 0) {
                a = nums[i];
                countA = 1;
            } else if (countB == 0) {
                b = nums[i];
                countB = 1;
            } else {
                countA--;
                countB--;
            }
        }
        int cnt_1 = 0, cnt_2 = 0;
        for (int i = 0; i < len; i++) {
            if (countA > 0 && a == nums[i]) cnt_1++;
            else if (countB > 0 && b == nums[i]) cnt_2++;
        }
        if (cnt_1 > len / 3) {
            re.add(a);
        }
        if (cnt_2 > len / 3) {
            re.add(b);
        }
        return re;
    }
}
