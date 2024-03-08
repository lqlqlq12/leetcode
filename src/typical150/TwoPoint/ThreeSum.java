package typical150.TwoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15.三数之和
/*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j],
nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。
请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。*/
//思路 先对数组排序 先确定left 然后mid和right向中间靠拢
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int left = 0; left <= len - 3; left++) {
            if (left == 0 || nums[left] != nums[left - 1]) {
                if (nums[left] > 0) {
                    break;
                }
                for (int mid = left + 1, right = len - 1; mid < right; mid++) {
                    if (mid == left + 1 || nums[mid] != nums[mid - 1]) {
                        while (nums[left] + nums[mid] + nums[right] > 0 && mid < right) {
                            right--;
                        }
                        if (mid == right) {
                            break;
                        }
                        if (nums[left] + nums[mid] + nums[right] == 0) {
                            re.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                        }
                    }
                }
            }
        }
        return re;
    }

    public void test() {
        threeSum(new int[]{1, -1, -1, 0});
    }

    public static void main(String[] args) {
        new ThreeSum().test();
    }
}
