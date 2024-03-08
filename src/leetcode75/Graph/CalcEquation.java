package leetcode75.Graph;

import java.util.*;

//399.除法求值
/*给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。*/
//思路 用两个map<String,List<String> map1{key:a,value[b,c,d]} map2{key:a,value[1.0,2.0,3.4]}
//a/b=1.0,a/c-2.0,a/d=3.4
//然后用dfs
public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> outcome = new HashMap<>();
        double[] re = new double[queries.size()];
        Arrays.fill(re, -1.0);
        int len = equations.size();
        for (int i = 0; i < len; i++) {
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            if (!pairs.containsKey(x)) {
                pairs.put(x, new ArrayList<>());
                outcome.put(x, new ArrayList<>());
            }
            if (!pairs.containsKey(y)) {
                pairs.put(y, new ArrayList<>());
                outcome.put(y, new ArrayList<>());
            }
            pairs.get(x).add(y);
            outcome.get(x).add(values[i]);
            pairs.get(y).add(x);
            outcome.get(y).add(1 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!pairs.containsKey(x) || !pairs.containsKey(y)) {
                re[i] = -1.0;
                continue;
            }
            if (x.equals(y)) {
                re[i] = 1;
                continue;
            }
            Map<String, Double> t = new HashMap<>();
            t.put(x, 1.0);
            Queue<String> queue = new LinkedList<>();
            queue.offer(x);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int j;
                for (j = 0; j < size; j++) {
                    String alpha = queue.poll();
                    List<String> list = pairs.get(alpha);
                    double tVal = t.get(alpha);
                    int k;
                    for (k = 0; k < list.size(); k++) {
                        if (!t.containsKey(list.get(k))) {
                            t.put(list.get(k), tVal * outcome.get(alpha).get(k));
                            if (list.get(k).equals(y)) {
                                re[i] = t.get(list.get(k));
                                break;
                            }
                            queue.offer(list.get(k));
                        }
                    }
                    if (k < list.size()) {
                        break;
                    }
                }
                if (j < size) {
                    break;
                }
            }
        }
        return re;
    }

    public void test() {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation_1 = new ArrayList<>();
        List<String> equation_2 = new ArrayList<>();
        equation_1.add("a");
        equation_1.add("b");
        equation_2.add("b");
        equation_2.add("c");
        equations.add(equation_1);
        equations.add(equation_2);
        double[] values = new double[2];
        values[0] = 2.0;
        values[1] = 3.0;
        //["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]
        List<List<String>> queries = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("c");
        List<String> l2 = new ArrayList<>();
        l2.add("b");
        l2.add("a");
        List<String> l3 = new ArrayList<>();
        l3.add("a");
        l3.add("e");
        List<String> l4 = new ArrayList<>();
        l4.add("a");
        l4.add("a");
        List<String> l5 = new ArrayList<>();
        l4.add("x");
        l4.add("x");
        queries.add(l1);
        queries.add(l2);
        queries.add(l3);
        queries.add(l4);
        queries.add(l5);
        calcEquation(equations, values, queries);
    }

    public static void main(String[] args) {
        new CalcEquation().test();
    }
}
