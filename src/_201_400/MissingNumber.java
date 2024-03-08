package _201_400;

//268.丢失的数字
/*给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。*/
//你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
//如果[0,n]都有的话 则总和为 n*(n+1)/2
//位运算:可以将数组的全部元素异或 然后再和[0:n]异或一遍 这样出现包含的数字就异或了两次 未包含的数字就异或了一次
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length, re = n * (n + 1) / 2;
        for (int num : nums) {
            re -= num;
        }
        return re;
    }
}
