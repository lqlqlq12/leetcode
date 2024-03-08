package typical150.Array_String;

//189.轮转数组
/*给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数*/
/*尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？*/
//思路:先将nums[0:len-1]反转 ->[len-1,len-2....0]然后再将前k个反转][len-k,len-k+1...len-1...0]
//然后再将剩下的也反转
// 1 2 3 4 5 6 7 8 k=3;8 7 6 5 4 3 2 1; 6 7 8 5 4 3 2 1;6 7 8 1 2 3 4 5
public class Rotate {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
