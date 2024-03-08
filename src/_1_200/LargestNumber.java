package _1_200;

import java.util.Arrays;
import java.util.Comparator;

//179.最大数
/*给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。*/
//关于如何排序 x和y究竟谁排在前面
//其实就是 先x再y的结果和 先y在x的结果进行比较
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) sx *= 10;
            while (sy <= y) sy *= 10;
            long com1 = x * sy + y; //先x再y
            long com2 = y * sx + x; //先y再x
            return (int) (com2 - com1);
        });
        if (arr[0].equals(0)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }

    public int getFirst(int number) {
        while (number / 10 > 0) {
            number /= 10;
        }
        return number;
    }
}
