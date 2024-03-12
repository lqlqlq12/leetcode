package _201_400;

import java.util.Arrays;

//324.摆动排序II
/*给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

你可以假设所有输入数组都可以得到满足题目要求的结果。*/
//你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
//思路 先将数组排序 然后分为两部分 [0-mid]和[mid+1-n-1] 左边mid个 右边n-mid-1个 mid==n-mid-1(n是奇数)
//左边-右边==1(n是偶数) 所以可以把右边的一次插入到左边的 也可以理解为双指针 轮流的那种 先小后大
//暂时不知道怎么O(n) 先做吧 发现交换起来还挺麻烦 那就隔位交换
//1 2 3 4 5 6 将2和5(mid+2)交换 len是偶数
//1 5 3 4 2 6
//1 2 3 4 5 6 7 将2和5(mid+1)交换 len是奇数
//1 5 3 7 2 6 4
//1 1 1 4 5 6
//1 1 2 2 3 3
//1 3 2 2 1 3
//官解 如果是偶数 左右部分一样多 先右后左
//如果是奇数 左边比右边多 先左后右 不好证明 就这样把
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int len = nums.length, index = len - 1, i = 0, j = (len + 1) >> 1;
        if (len % 2 == 0) {
            for (; index > 0; index -= 2) {
                nums[index] = arr[j++];
                nums[index - 1] = arr[i++];
            }
        } else {
            nums[index--] = arr[i++];
            for (; index > 0; index -= 2) {
                nums[index] = arr[j++];
                nums[index - 1] = arr[i++];
            }
        }
    }
}
