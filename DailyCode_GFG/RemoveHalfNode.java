package DailyCode_GFG;

// GFG : https://www.geeksforgeeks.org/problems/remove-half-nodes/1
//Question : Remove Half Nodes


public class RemoveHalfNode {
    public static class Node{
        int data;
        Node left,right;
        Node(int d){
            this.data=d;
            left=right=null;
        }
    }
    public static Node removenode(Node root){
        if(root==null){
            return null;
        }
        root.left=removenode(root.left);
        root.right=removenode(root.right);
        if (root.left==null && root.right !=null){
            return root.right;
        }
        if (root.right==null && root.left !=null){
            return root.left;
        }
        return root;
    }
    public static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }
    public static void main(String[] args) {
       Node root = new Node(5);
       root.left=new Node(7);
       root.left.left= new Node(2);
       root.right= new Node(8);

       Node remove= removenode(root);
       inorderTraversal(remove);
    }
}
