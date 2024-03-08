package typical150.BitCalc;

//137.只出现一次的数字II
/*给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。*/
//上一次的是只出现两次 用了异或运算
//大神做法:模拟三进制 额.....(0,0)->(0,1)->(1,0)->(0,0) one,two分别表示三进制的高低位
//题解 统计32位每一位1的个数 出现三次的要么3个0或者3个1 所以4个1的地方就为1 O(32n)
public class SingleNumber_2 {
    public int singleNumber(int[] nums) {
        //one放的是高位,two放的是低位 one=0时,two才能从0变1 two=1时,one才能从0变1
        int one = 0, two = 0;
        for (int num : nums) {
            two = (two ^ num) & (~one);
            one = (one ^ num) & (~two);
        }
        return two;
    }
}
