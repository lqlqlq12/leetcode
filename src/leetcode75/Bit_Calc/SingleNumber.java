package leetcode75.Bit_Calc;

//136.只出现一次的数字
/*给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。*/
//思路:用异或运算
//异或:0^0=0 1^1=0 1^0=1
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int re = 0;
        for (int num : nums) {
            re ^= num;
        }
        return re;
    }
}
