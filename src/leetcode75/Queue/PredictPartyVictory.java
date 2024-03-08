package leetcode75.Queue;

import java.util.LinkedList;
import java.util.Queue;

//649.Dota2 参议院
/*Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）

Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：

禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。
然后，如果有 n 个参议员，给定字符串的大小将是 n。

以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。
这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。*/
//思路:最好的政策就是禁对面的言,并且是尽可能的往前禁言,是往后的禁言,但尽量往前,否则对方就会禁己方的言(贪心)
//如果当前的是最后一个,就从头开始往后
//非常慢,官解:用两个队列表示两个阵营按顺序的获取权力的顺序 也是把数组优化成队列
public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();
        int len = charArray.length;
        boolean[] banned = new boolean[len];
        int rCount = 0, dCount = 0;
        for (char c : charArray) {
            if (c == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }
        while (rCount != 0 && dCount != 0) {
            for (int i = 0; i < len; i++) {
                if (banned[i]) {
                    continue;
                }
                for (int j = i + 1; ; j++) {
                    if (j == len) {
                        j = 0;
                    }
                    if (charArray[i] != charArray[j] && !banned[j]) {
                        banned[j] = true;
                        if (charArray[j] == 'R') {
                            rCount--;
                            if (rCount == 0) {
                                return "Dire";
                            }
                        } else {
                            dCount--;
                            if (dCount == 0) {
                                return "Radiant";
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (rCount == 0) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    public String optimize(String senate) {
        char[] charArray = senate.toCharArray();
        int len = charArray.length;
        Queue<Integer> rqueue = new LinkedList<>();
        Queue<Integer> dqueue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (charArray[i] == 'R') {
                rqueue.offer(i);
            } else {
                dqueue.offer(i);
            }
        }
        while (!rqueue.isEmpty() && !dqueue.isEmpty()) {
            int r = rqueue.poll(), d = dqueue.poll();
            if (r < d) {
                rqueue.offer(r + len);
            } else {
                dqueue.offer(d + len);
            }
        }
        return rqueue.isEmpty() ? "Dire" : "Radiant";
    }

    public void test() {
        System.out.println(predictPartyVictory("RDD"));
    }

    public static void main(String[] args) {
        new PredictPartyVictory().test();
    }
}
