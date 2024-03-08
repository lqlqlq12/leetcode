package _1_200;

import java.util.*;

//126.单词接龙II
/*按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列

是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：

每对相邻的单词之间仅有单个字母不同。

转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。

注意，beginWord 不必是字典 wordList 中的单词。
sk == endWord
给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。

请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。

每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。*/
//思路:应该还是广度优先
//还是很容易超时 要双向寻找
//官解:先bfs遍历直到找到最短的路径 遍历的同时记录每个结点可以由哪些结点变化得到和到达每个结点所需的步长
//然后再通过回溯构造遍历路径 放弃了
public class FindLadders {
    List<List<String>> re;
    Set<String> wordSet;
    boolean flag;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        re = new ArrayList<>();
        flag = false;
        wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        if (!wordSet.contains(endWord)) {
            return re;
        }
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue_reverse = new LinkedList<>();
        Queue<List<String>> step = new LinkedList<>();
//        Queue<List<String>> step_reverse = new LinkedList<>();
        queue.offer(beginWord);
        queue_reverse.offer(endWord);
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        step.offer(temp);
//        temp.set(0, endWord);
//        step_reverse.offer(temp);
        while (!queue.isEmpty() && !queue_reverse.isEmpty()) {
            int size = queue.size(), size_reverse = queue_reverse.size();
            Set<String> used = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> list = step.poll();
                changeByOneLetter(word, queue_reverse, list, queue, step, used);
            }
            wordSet.removeAll(used);
            if (!re.isEmpty()) {
                return re;
            }
            for (int i = 0; i < size_reverse; i++) {
                String word = queue_reverse.poll();
                changeByOneLetterReverse(word, queue_reverse, used);
            }
            wordSet.removeAll(used);
        }
        return re;
    }

    public void changeByOneLetter(String beginWord, Queue<String> endWords, List<String> list, Queue<String> queue, Queue<List<String>> step, Set<String> used) {
        char[] charArray = beginWord.toCharArray();
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            char before = charArray[i];
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (letter == before) continue;
                charArray[i] = letter;
                String nextWord = String.valueOf(charArray);
                if (endWords.contains(nextWord)) {
                    flag = true;
                    list.add(nextWord);
                    re.add(list);
                } else if (wordSet.contains(nextWord)) {
                    used.add(nextWord);
                    queue.offer(nextWord);
                    List<String> t = new ArrayList<>(list);
                    t.add(nextWord);
                    step.offer(t);
                }
            }
            charArray[i] = before;
        }
    }

    public void changeByOneLetterReverse(String endWord, Queue<String> queue, Set<String> used) {
        char[] charArray = endWord.toCharArray();
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            char before = charArray[i];
            for (char letter = 'a'; letter <= 'z'; letter++) {
                if (letter == before) continue;
                charArray[i] = letter;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    used.add(nextWord);
                    queue.offer(nextWord);
                }
            }
            charArray[i] = before;
        }
    }

    public void test() {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        findLadders("hit", "cog", wordList);
    }

    public static void main(String[] args) {
        new FindLadders().test();
    }
}
