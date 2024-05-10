package _401_600;

//406.根据身高重建队列
/*假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。*/
//官解:身高从低到高开始考虑 先确定矮的人的位置 当要确定某人的位置时，没有人比他更矮了 都是大于等于他的
//如果要求这个人前面有3个大于等于他的 那就在他的前面留三个空即可
//对于身高相同的 k大的在后面，所以可以理解为k大的身高高了那么一丢丢，所以排序的时候 身高相同的按k降序排
//k大的先选位置 留好空
//考虑从大到小 先确定大的位置 当要确定某一个人的位置时，已经确定好位置的都是大于等于的 所以直接插到位置k就行
//如果后续再被插入也不会影响结果
import org.junit.Test;

import java.util.*;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        int len = people.length;
        int[][] ans = new int[len][];
        for (int[] person : people) {
            int k = person[1];
            int position = -1;
            for (int i = 0; i < len; i++) {
                if (ans[i] == null) {
                    position++;
                    if (position == k) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int[][] optimize(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        int len = people.length;
        List<int[]> que=new LinkedList<>();
        for (int[] person : people) {
            que.add(person[1],person);
        }
        return que.toArray(new int[len][]);
    }

    @Test
    public void test() {
        optimize(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}


