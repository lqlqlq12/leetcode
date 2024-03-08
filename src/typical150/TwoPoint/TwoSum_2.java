package typical150.TwoPoint;

//两数之和II - 输入有序数组
/*给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。

以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。

你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。

你所设计的解决方案必须只使用常量级的额外空间。*/
//要求常量的额外空间 不能用哈希表额 有序->二分? O(nlogn)
//最优解:从左往右遍历 对于下标0 找到一个下标i 使得x[0]+x[i]>target,x[0]+x[i-1]<target
//对于x[1],如果x[1]>x[0] 那么可以排除x[i],从i往右找可能解,找到j为止,满足x[1]+x[j]>target,x[1]+x[j-1]<target
//以上方法是双指针
//好吧 真正的双指针不要这么麻烦 直接一个left 和 right 向中间靠拢就行了
public class TwoSum_2 {
    public int[] twoSum(int[] numbers, int target) {
        int left, len = numbers.length, right = len - 1;
        if (numbers[0] + numbers[1] == target) {
            return new int[]{1, 2};
        }
        for (int i = 2; i < len; i++) {
            if (numbers[i] != numbers[0]) {
                if (numbers[i] + numbers[0] == target) {
                    return new int[]{1, i + 1};
                }
                if (numbers[i] + numbers[0] > target && numbers[i - 1] + numbers[0] < target) {
                    right = i - 1;
                    break;
                }
            }
        }
        for (left = 1; left < right; left++) {
            while (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (right + 1 < len && numbers[left] + numbers[right + 1] > target) {
                right++;
            }

        }
        return null;
    }

    public int[] twoPoint(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
