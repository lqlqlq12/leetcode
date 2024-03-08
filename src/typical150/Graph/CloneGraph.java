package typical150.Graph;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

//克隆图
/*给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

class Node {
    public int val;
    public List<Node> neighbors;
}


测试用例格式：

简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。

邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。

给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。*/
//和之前的克隆链表类似,可以用HashMap保存key是原节点,value是克隆的节点 分bfs和dfs
//可以遍历一遍创建好节点之后,然后再建立克隆节点的连接,也可以在遍历过程就克隆好节点同时建立连接
public class CloneGraph {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Node> map;
    Set<Node> visited;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        map = new HashMap<>();
        visited = new HashSet<>();
        dfsCreate(node);
        dfsLink(node);
        return map.get(node);
    }

    public void dfsCreate(Node node) {
        if (map.containsKey(node))
            return;
        Node now = new Node(node.val);
        map.put(node, now);
        for (int i = 0; i < node.neighbors.size(); i++) {
            dfsCreate(node.neighbors.get(i));
        }
    }

    public void dfsLink(Node node) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        Node cloned = map.get(node);
        for (int i = 0; i < node.neighbors.size(); i++) {
            cloned.neighbors.add(map.get(node.neighbors.get(i)));
            dfsLink(node.neighbors.get(i));
        }
    }

    public Node bfs(Node node) {
        if (node == null) return node;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map = new HashMap<>();
        visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!map.containsKey(now)) {
                Node clone = new Node(now.val);
                map.put(now, clone);
                for (int i = 0; i < now.neighbors.size(); i++) {
                    queue.offer(now.neighbors.get(i));
                }
            }
        }
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (!visited.contains(now)) {
                visited.add(now);
                Node cloned = map.get(node);
                for (Node neighbor : now.neighbors) {
                    cloned.neighbors.add(map.get(neighbor));
                    queue.offer(neighbor);
                }
            }
        }
        return map.get(node);
    }

    public Node one_dfs(Node node) {
        if (node == null) return node;
        map = new HashMap<>();
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(one_dfs(neighbor));
        }
        return clone;
    }

    public Node one_bfs(Node node){
        if(node==null) return node;
        Queue<Node> queue=new LinkedList<>();
        map=new HashMap<>();
        queue.offer(node);
        map.put(node,new Node(node.val));
        while(!queue.isEmpty()){
            Node now=queue.poll();
            Node clone=map.get(now);

            for (Node neighbor : now.neighbors) {
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                clone.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

}
