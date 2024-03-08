package _201_400;

import java.util.*;

//315.计算右侧小于当前元素的个数
/*给你一个整数数组 nums ，按要求返回一个新数组 counts 。

数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。*/
//官解:离散化树状数组 首先维护一个桶 bucket bucket[i]的含义是i出现了bucket[i]次
//所以从后往前遍历的时候 维护这样一个桶 每遍历一次都计算一次 小于nums[i]的元素的出现次数
//但是如果nums的跨度很大 很多元素没有出现 会导致bucket数组会有很多空的地方
//所以对数组进行去重后得到size 就说明只要size大小的桶就足够了 然后就要确定每个元素在桶应该在哪个地方
//所以先对nums去重然后排序 排序后下标为index 那么这个元素在bucket就应该是index的位置
//比如说遍历到nums[i] 需要知道nums[i]在桶里面的位置 可以对destination数组二分查找 快速找到下标
//树状node(i)的含义是前i个元素的和
//要求前i个元素的和时 while{sum+=node[i],i-=lowbit(i)}
//将第i个元素的值加1时 while{node[i]+=1,i+=lowbit(i)}}
//官解 方法二:用归并排序 首先如果已经排序好 现在需要合并 对于左部分的某个元素x
//右部分会比它小的元素因为已经排序好所以可以很快得到
//那么接下来只要考虑左变部分比x小的有哪些 因为左边已经排序好 所以排号序的序列中比x小的不仅有x的左边的 也有右边的
//所以 归并要自底向上
public class CountSmaller {
    int[] destination;
    int[] occurCount;

    public List<Integer> countSmaller(int[] nums) {
        setAndSort(nums);
        List<Integer> re = new ArrayList<>();
        int len = nums.length;
        occurCount = new int[destination.length];
        for (int i = len - 1; i >= 0; i--) {
            int index = getIndex(nums[i]);
            re.add(getSmaller(index - 1));
            update(index);
        }
        Collections.reverse(re);
        return re;
    }


    public void setAndSort(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int index = 0;
        destination = new int[set.size()];
        for (Integer i : set) {
            destination[index++] = i;
        }
        Arrays.sort(destination);
    }

    //返回最后一个1
    public int lowBit(int num) {
        return num & (-num);
    }

    //返回小于occurCount[index-1]的元素的个数
    public int getSmaller(int index) {
        int re = 0;
        while (index > 0) {
            re += occurCount[index - 1];
            index -= lowBit(index);
        }
        return re;
    }

    //occurCount[index-1]的元素增加1 从子节点出发 依次将父节点加1
    public void update(int index) {
        while (index <= occurCount.length) {
            occurCount[index - 1]++;
            index += lowBit(index);
        }
    }

    //返回num是第几个大的 [1:len]
    public int getIndex(int num) {
        return Arrays.binarySearch(destination, num) + 1;
    }
}
