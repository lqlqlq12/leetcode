package _201_400;

import org.junit.Test;

import java.util.*;

//332.重新安排行程
/*给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。

所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。

例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。*/
//思路:dfs+回溯 先回溯字典序小的
//竟然超时了 和官解不同之处在于:我的做法是此路不同时 回溯 poll下一个 将不通的offer回去 但官解证明得到
//最多只有一个这样的路径是死胡同 其他路径最终都会回到此节点 所以就是最后再走这个死胡同 也就是说不需要回溯
//正确做法:用一个栈将死胡同入栈 栈底就是死胡同的终点 栈顶就是死胡同的入口 因为将死胡同的入口poll了 所以剩下的都可以回到此点
//官解是直接全部入栈 先while(dfs)然后再将这个点入栈 这样最先跳出while循环的就是死胡同那条线 栈底也是死胡同终点
//然后就是其他非死胡同的点 越靠近终点的越早入栈 所以最后依次出栈 再倒序一下
public class FindItinerary {
    List<String> re;
    Deque<String> stack;
    int size;
    Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        re = new ArrayList<>();
        stack = new LinkedList<>();
        size = tickets.size();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        backTrack("JFK");
        re.add(0, "JFK");
        re.addAll(stack);
        return re;
    }

    public boolean backTrack(String position) {
        if (re.size() + stack.size() == size) {
            return true;
        }
        if (!map.containsKey(position)) {
            return false;
        }
        PriorityQueue<String> queue = map.get(position);
        while (!queue.isEmpty()) {
            String next = queue.poll();
            re.add(next);
            if (backTrack(next)) {
                return true;
            } else {
                stack.push(next);
            }
            re.remove(re.size() - 1);
        }
        return false;
    }


    @Test
    public void test() {

        List<String> t = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        t.add("EZE");
        t.add("TIA");
        list.add(new ArrayList<>(t));
        t.set(0, "EZE");
        t.set(1, "HBA");
        list.add(new ArrayList<>(t));
        t.set(0, "AXA");
        t.set(1, "TIA");
        list.add(new ArrayList<>(t));
        t.set(0, "JFK");
        t.set(1, "AXA");
        list.add(new ArrayList<>(t));
        t.set(0, "ANU");
        t.set(1, "JFK");
        list.add(new ArrayList<>(t));
        t.set(0, "ADL");
        t.set(1, "ANU");
        list.add(new ArrayList<>(t));
        t.set(0, "TIA");
        t.set(1, "AUA");
        list.add(new ArrayList<>(t));
        t.set(0, "ANU");
        t.set(1, "AUA");
        list.add(new ArrayList<>(t));
        t.set(0, "ADL");
        t.set(1, "EZE");
        list.add(new ArrayList<>(t));
        t.set(0, "ADL");
        t.set(1, "EZE");
        list.add(new ArrayList<>(t));
        t.set(0, "EZE");
        t.set(1, "ADL");
        list.add(new ArrayList<>(t));
        t.set(0, "AXA");
        t.set(1, "EZE");
        list.add(new ArrayList<>(t));
        t.set(0, "AUA");
        t.set(1, "AXA");
        list.add(new ArrayList<>(t));
        t.set(0, "JFK");
        t.set(1, "AXA");
        list.add(new ArrayList<>(t));
        t.set(0, "AXA");
        t.set(1, "AUA");
        list.add(new ArrayList<>(t));
        t.set(0, "AUA");
        t.set(1, "ADL");
        list.add(new ArrayList<>(t));
        t.set(0, "ANU");
        t.set(1, "EZE");
        list.add(new ArrayList<>(t));
        t.set(0, "TIA");
        t.set(1, "ADL");
        list.add(new ArrayList<>(t));
        t.set(0, "EZE");
        t.set(1, "ANU");
        list.add(new ArrayList<>(t));
        t.set(0, "AUA");
        t.set(1, "ANU");
        list.add(new ArrayList<>(t));
        findItinerary(list);
    }
}
