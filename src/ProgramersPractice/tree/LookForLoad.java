package ProgramersPractice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LookForLoad {
    public static void main(String[] args) {
        int[][] nodeinfo = {{3, 2}, {1, 1}, {4, 3}};
        Solution solution=new Solution();
        solution.solution(nodeinfo);
    }

}

class Solution {
    class Node {
        int vtx;
        int x;
        int y;
        Node left;
        Node right;

        Node(int vtx, int x, int y, Node left, Node right) {
            this.vtx = vtx;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }

    ArrayList<Node> nodes;
    int idx;
    int[][] answer;

    void insertNode(Node parent, Node child) {
        if(parent == child) return;

        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    void preOrder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.vtx;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            answer[1][idx++] = root.vtx;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }

        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.y - o1.y;
            }
        });

        Node root = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }

        answer = new int[2][nodes.size()];

        idx = 0;
        preOrder(root);
        idx=0;
        postOrder(root);

        return answer;
    }
}

