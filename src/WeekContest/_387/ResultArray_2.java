package WeekContest._387;

import org.junit.Test;

import java.util.*;

//100246.将元素分配到两个数组中 II
/*给你一个下标从 1 开始、长度为 n 的整数数组 nums 。

现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。

你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：

如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
如果仍然相等，那么将 nums[i] 追加到 arr1 。
连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。

返回整数数组 result 。*/
//先对nums去重排序 然后两个arr分别保存一个index数组 index[i]!=0表示nums[index[i]]在此arr里面
//然后求index数组的前缀和 可以用树状数组
public class ResultArray_2 {
    int[] index1, index2;
    int[] arr;

    public int[] resultArray(int[] nums) {
        int len = nums.length;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        setAndSort(nums);
        l1.add(nums[0]);
        l2.add(nums[1]);
        update(getId(nums[0]), index1);
        update(getId(nums[1]), index2);
        for (int i = 2; i < len; i++) {
            int index = getId(nums[i]);
            int x = l1.size() - query(index, index1), y = l2.size() - query(index, index2);
            if (x > y) {
                l1.add(nums[i]);
                update(index, index1);
            } else if (x < y) {
                l2.add(nums[i]);
                update(index, index2);
            } else {
                if (l1.size() <= l2.size()) {
                    l1.add(nums[i]);
                    update(index, index1);
                } else {
                    l2.add(nums[i]);
                    update(index, index2);
                }
            }
        }
        int[] re = new int[len];
        int index = 0;
        for (Integer i : l1) {
            re[index++] = i;
        }
        for (Integer i : l2) {
            re[index++] = i;
        }
        return re;
    }

    public void setAndSort(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        index1 = new int[size];
        index2 = new int[size];
        arr = new int[size];
        int index = 0;
        for (Integer i : set) {
            arr[index++] = i;
        }
        Arrays.sort(arr);
    }

    public int query(int index, int[] ar) {
        int re = 0;
        while (index > 0) {
            re += ar[index - 1];
            index -= lowBit(index);
        }
        return re;
    }


    public void update(int index, int[] ar) {
        int size = ar.length;
        while (index <= size) {
            ar[index - 1]++;
            index += lowBit(index);
        }
    }

    public int lowBit(int num) {
        return num & (-num);
    }

    //返回在arr中num是第几个小的 也就是 [1:n]
    public int getId(int num) {
        return Arrays.binarySearch(arr, num) + 1;
    }

    @Test
    public void test() {
        resultArray(new int[]{2, 28, 2});
    }
}
