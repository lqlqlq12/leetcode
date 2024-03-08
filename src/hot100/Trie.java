package hot100;


//实现Trie(前缀树)
/*Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。*/
public class Trie {

    private Trie[] children;
    private boolean isEnd;


    public Trie() {
        children = new Trie[26];
        isEnd=false;
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if(node.children[index]==null){
                node.children[index]=new Trie();
            }
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Trie node=this;
        for(int i=0;i<charArray.length;i++){
            int index=charArray[i]-'a';
            if(node.children[index]==null){
                return false;
            }
            node=node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        Trie node=this;
        for(int i=0;i<charArray.length;i++){
            int index=charArray[i]-'a';
            if(node.children[index]==null){
                return false;
            }
            node=node.children[index];
        }
        return true;
    }
}
