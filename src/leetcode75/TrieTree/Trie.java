package leetcode75.TrieTree;

//208.实现Trie(前缀树)
/*Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。*/
public class Trie {
    boolean isEnd;
    Trie[] childs;

    public Trie() {
        isEnd = false;
        childs = new Trie[26];
    }

    public void insert(String word) {
        Trie root = this;
        char[] charArray = word.toCharArray();
        int len = charArray.length, index = 0;
        while (index < len && root.childs[charArray[index] - 'a'] != null) {
            root = root.childs[charArray[index] - 'a'];
            index++;
        }
        while (index < len) {
            root.childs[charArray[index] - 'a'] = new Trie();
            root = root.childs[charArray[index] - 'a'];
            index++;
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        Trie root = this;
        char[] charArray = word.toCharArray();
        int len = charArray.length, index = 0;
        while (index < len && root.childs[charArray[index] - 'a'] != null) {
            root = root.childs[charArray[index] - 'a'];
            index++;
        }
        if (index < len) {
            return false;
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] charArray = prefix.toCharArray();
        int len = charArray.length, index = 0;
        while (index < len && root.childs[charArray[index] - 'a'] != null) {
            root = root.childs[charArray[index] - 'a'];
            index++;
        }
        return index == len;
    }
}
