package typical150.Array_String;

//169.多数元素 (2刷
/*给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/
//思路:1.hashMap 2.候选人投票算法 3.排序取中间位置
public class MajorityElement {
    //候选人投票
    public int majorityElement(int[] nums) {
        int count = 0, len = nums.length, candidate = nums[0];
        for (int i = 0; i < len; i++) {
            if (candidate == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
