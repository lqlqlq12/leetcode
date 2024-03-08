package hot100;

import java.util.Arrays;

//下一个排列
/*例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。*/
/*必须 原地 修改，只允许使用额外常数空间*/
// 5 9 9 1 4 1 1 2 3 1 2 4 9 2 1 1 0 1 8 8 8
//双指针?l,r l从后往前遍历,r是l右边第一个比l对应的值大的地方,交换l,r,如果l遍历到了-1,reverse数组
//优化:有效的l出现的地方,必然是nums[l]<nums[l+1],并且nums[l+1:end]是降序,所以r从后往前找,第一个小于nums[l]的地方就是r，交换后排序,用不着排序,因为本来就降序,直接翻转后面的就可以
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int l = len - 2;
        for (; l >= 0; l--) {
            if (nums[l] < nums[l + 1]) {
                break;
            }
        }
        if (l >= 0) {
            for (int r = len - 1; r >= l; r--) {
                if (nums[r] > nums[l]) {
                    int t = nums[l];
                    nums[l] = nums[r];
                    nums[r] = t;
                    reverse(nums, l + 1, nums.length - 1);
                    return;
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}
