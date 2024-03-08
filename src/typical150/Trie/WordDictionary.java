package typical150.Trie;

import java.util.LinkedList;
import java.util.Queue;

//添加与搜索单词 数据结构设计
/*请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。*/
//之前做过 用字典数 数的节点有当前char,后续节点,是否是一个单词的结尾
//一遍过 注意构造不要有返回类型
//优化 使用bfs,虽然节省了空间 但是好像很慢 试一试dfs
public class WordDictionary {
    private class Node {
        Node[] child;
        boolean isEnd;

        public Node() {
            child = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        char[] charArray = word.toCharArray();
        Node node = root;
        int len = charArray.length;
        int index = 0;
        while (index < len && node.child[charArray[index] - 'a'] != null) {
            node = node.child[charArray[index] - 'a'];
            index++;
        }
        while (index < len) {
            node.child[charArray[index] - 'a'] = new Node();
            node = node.child[charArray[index] - 'a'];
            index++;
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
//        char[] charArray = word.toCharArray();
//        int len = charArray.length;
//        Queue<Node> queue = new LinkedList<>();
//        int index = 0;
//        if (charArray[index] == '.') {
//            for (int i = 0; i < 26; i++) {
//                if (root.child[i] != null) {
//                    queue.offer(root.child[i]);
//                }
//            }
//        } else if (root.child[charArray[index] - 'a'] != null) {
//            queue.offer(root.child[charArray[index] - 'a']);
//        }
//        index++;
//        while (index < len && !queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                if (charArray[index] == '.') {
//                    for (int j = 0; j < 26; j++) {
//                        if (null != node.child[j]) {
//                            queue.offer(node.child[j]);
//                        }
//                    }
//                } else if (node.child[charArray[index] - 'a'] != null) {
//                    queue.offer(node.child[charArray[index] - 'a']);
//                }
//            }
//            index++;
//        }
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            if (node.isEnd) {
//                return true;
//            }
//        }
//        return false;
    }

    public boolean dfs(String word, int index, Node node) {
        if (index == word.length() && node.isEnd) {
            return true;
        } else if (index == word.length()) {
            return false;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    if (dfs(word, index + 1, node.child[i])) {
                        return true;
                    }
                }
            }
        } else {
            int number = word.charAt(index) - 'a';
            return node.child[number] != null && dfs(word, index + 1, node.child[number]);
        }
        return false;
    }
}
