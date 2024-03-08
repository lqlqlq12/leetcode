package typical150.Graph;

import java.util.*;

//最小基因变化
/*基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。

假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。

例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）

给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。

注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。*/
//思路:dfs,bfs
public class MinMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> banks = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Collections.addAll(banks, bank);
        if (!banks.contains(endGene)) {
            return -1;
        }
        if (startGene.equals(endGene)) return 0;
        char[] re = {'A', 'C', 'G', 'T'};
        int ans=0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (re[k] == str.charAt(j)) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder(str);
                        sb.setCharAt(j, re[k]);
                        String s = sb.toString();
                        if(s.equals(endGene)){
                            return ans;
                        }
                        if(banks.contains(s)&&!visited.contains(s)){
                            visited.add(s);
                            queue.offer(s);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
