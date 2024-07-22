package DailyCode_GFG;

//GFG : https://www.geeksforgeeks.org/problems/largest-bst/1
// Question : Largest BST

class Node {
    int data;
    Node left, right;
    public Node(int d) {
        data = d;
        left = right = null;
    }
}
public class LargestBst {
    static class NodeInfo {
        int max, min, size;
        NodeInfo(int min, int max, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    private static NodeInfo helper(Node root) {
        if (root == null) {
            return new NodeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);
        if (left.max < root.data && root.data < right.min) {
            return new NodeInfo(Math.min(root.data, left.min), Math.max(root.data, right.max), left.size + right.size + 1);
        }
        return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }
    static int largestBst(Node root) {
        return helper(root).size;
    }
}
