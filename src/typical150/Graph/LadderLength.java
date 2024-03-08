package typical150.Graph;

import java.util.*;

//单词接龙
/*字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：

每一对相邻的单词只差一个字母。
 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
sk == endWord
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。*/
//bfs 不重复?
//优化 双向dfs 要遍历的的单词会更少 更快 不想写
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int re = 1;
        while (!queue.isEmpty()) {
            re++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String pre = queue.poll();
                if (changeWordByOneLetter(pre, endWord, wordSet, visited, queue)) {
                    return re;
                }
            }
        }
        return 0;
    }

    public boolean changeWordByOneLetter(String word, String endWord, Set<String> wordSet, Set<String> visited, Queue<String> queue) {
        char[] charArray = word.toCharArray();
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            char before = charArray[i];
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (letter == before)
                    continue;
                charArray[i] = letter;
                String next = String.valueOf(charArray);
                if (next.equals(endWord)) {
                    return true;
                }
                if (wordSet.contains(next)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            charArray[i] = before;
        }
        return false;
    }


}
