package hot100;

//136.只出现一次的数字
/*给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。*/
//异或运算 位数相同为0,不同为1
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            re = re ^ nums[i];
        }
        return re;
    }
}
