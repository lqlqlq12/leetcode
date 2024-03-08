package leetcode75.Heap_PriorityQueue;

//215.数组中的第k个最大元素
/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。*/
//快速选择
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        int i = left, j = right, t = nums[left];
        for (int s = i; s <= j; ) {
            if (nums[s] < t) {
                int temp = nums[s];
                nums[s] = nums[i];
                nums[i] = temp;
                i++;
                s++;
            } else if (nums[s] > t) {
                int temp = nums[s];
                nums[s] = nums[j];
                nums[j] = temp;
                j--;
            } else {
                s++;
            }
        }
        int index1 = right - i + 1, index2 = right - j + 1;
        if (index1 >= k && k >= index2) {
            return t;
        } else if (k > index1) {
            return quickSelect(nums, left, i - 1, k - index1);
        } else {
            return quickSelect(nums, j + 1, right, k);
        }
    }

    public void test() {
        findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    public static void main(String[] args) {
        new FindKthLargest().test();
    }
}
