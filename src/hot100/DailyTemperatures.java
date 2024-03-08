package hot100;

//每日温度
/*给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
如果气温在这之后都不会升高，请在该位置用 0 来代替。*/
//暴力 O(n^2)
//从后往前遍历
//单调栈 栈单调递减 栈内的元素是目前还没找到更高温度的温度对应的下标
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                answer[i] = 1;
            } else {
                int j = i + 1;
                while (answer[j] > 0 && temperatures[i] >= temperatures[j]) {
                    j += answer[j];
                }
                if (temperatures[i] < temperatures[j]) {
                    answer[i] = j - i;
                }
            }
        }
        return answer;
    }

    public void test() {
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static void main(String[] args) {
        new DailyTemperatures().test();
    }
}
