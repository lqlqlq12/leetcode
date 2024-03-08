package _1_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//90.子集II
/*给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。*/
//思路:先排序
public class SubsetsWithDup {
    int[] nums;
    List<List<Integer>> re;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        re = new ArrayList<>();
        this.nums = nums;
        for (int i = 0; i <= nums.length; i++) {
            recursion(i, 0, new ArrayList<>());
        }
        return re;
    }

    public void recursion(int target, int index, List<Integer> list) {
        if (list.size() == target) {
            re.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i == index || nums[i] != nums[i - 1]) {
                list.add(nums[i]);
                recursion(target, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
