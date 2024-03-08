package typical150.Graph;

import java.util.*;

//除法求值
/*给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。*/
//这题做过 用图 bfs dfs
//当有很多问题要求解是 每一次都要dfs图 非常麻烦 可以提前遍历 建立好每一个点的关系 然后就可以直接查找
public class CalcEquation {
    Map<String, List<String>> map;
    Map<String, List<Double>> value;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        value = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
            if (!value.containsKey(a)) {
                value.put(a, new ArrayList<>());
            }
            value.get(a).add(values[i]);
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
            if (!value.containsKey(b)) {
                value.put(b, new ArrayList<>());
            }
            value.get(b).add(1 / values[i]);
        }
        double[] re = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            visited.add(a);
            re[i] = getAnswer(a, b, visited);
        }
        return re;
    }

    public double getAnswer(String start, String end, Set<String> visited) {
        if (!map.containsKey(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }
        List<String> next = map.get(start);
        List<Double> values = value.get(start);
        for (int i = 0; i < next.size(); i++) {
            if (!visited.contains(next.get(i))) {
                visited.add(next.get(i));
                if (next.get(i).equals(end)) {
                    return values.get(i);
                }
                double re = getAnswer(next.get(i), end, visited);
                if (re != -1.0) {
                    return values.get(i) * re;
                }
            }
        }
        return -1.0;
    }


    public void test() {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        List<String> b = new ArrayList<>();
        b.add("b");
        b.add("c");
        double[] values = new double[]{2.0, 3.0};
        List<String> c = new ArrayList<>();
        c.add("a");
        c.add("c");
        List<List<String>> equa = new ArrayList<>();
        equa.add(a);
        equa.add(b);
        List<List<String>> ques = new ArrayList<>();
        ques.add(c);
        calcEquation(equa, values, ques);
    }

    public static void main(String[] args) {
        new CalcEquation().test();
    }
}
