package DailyCode_GFG;

public class CheckforBST {
    public  static boolean isBST(Node root){
        return  isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean isBSTUtil(Node root,int min,int max){
        if(root==null){
        return true;
        }
        if(root.data <=min || root.data>=max){
            return false;
        }
        return isBSTUtil(root.left, min,root.data) && isBSTUtil(root.right,root.data,max);
    }
    public static void main(String[] args) {
        Node root= new Node(2);
        root.left=new Node(1);
        root.right=new Node(6);
        root.right.left=new Node(4);
        root.right.right=new Node(9);

        System.out.println(isBST(root));
    }
}
