package _201_400;

import java.util.Random;

//384.打乱数组
/*给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。

实现 Solution class:

Solution(int[] nums) 使用整数数组 nums 初始化对象
int[] reset() 重设数组到它的初始状态并返回
int[] shuffle() 返回数组随机打乱后的结果*/
//思路:将下标添加到一个list 然后每次都随机从list里面拿一个下标出来
//官解:主要的优化的地方就是打乱的地方 这样子打乱需要O(n^2) 遍历O(n) 删除O(n-k) 所以O(n^2)
//可以不需要将选出来的元素从list移除 而是将其放在最前面或者最后面 这样就可以得到一个乱序后的区域 这样O(n)了
//相当于 打乱一副扑克牌 每次随机选一张 放在另一堆(牌堆或牌顶)
public class ShuffleAnArray {
    int[] origin;
    int len;

    public ShuffleAnArray(int[] nums) {
        this.origin = nums;
        len = nums.length;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
//        int[] newArray = new int[len];
//        Random random = new Random();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < len; i++) {
//            list.add(origin[i]);
//        }
//        for (int index = 0; index < len; index++) {
//            int target = random.nextInt(list.size());
//            newArray[index] = list.remove(target);
//        }
//        return newArray;
        int[] newArray = new int[len];
        System.arraycopy(origin, 0, newArray, 0, len);
        Random ran = new Random();
        for (int i = 0; i < len; i++) {
            int targetIndex = ran.nextInt(len - i) + i;
            int t = newArray[i];
            newArray[i] = newArray[targetIndex];
            newArray[targetIndex] = t;
        }
        return newArray;
    }
}
