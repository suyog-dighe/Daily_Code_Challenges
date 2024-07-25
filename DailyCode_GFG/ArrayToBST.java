package DailyCode_GFG;
import java.util.Arrays;

// GFG :-  https://www.geeksforgeeks.org/problems/array-to-bst4443/1
// Question :- Array to BST

public class ArrayToBST {
    public static Node sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private  static Node helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node node = new Node(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;
    }
    public static void main(String[] args) {
        int[] num = {5, 2, 6, 7, 8, 4};
        Node root = sortedArrayToBST(num);
        System.out.println("Preorder traversal of constructed BST:");
        preorder(root);
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
}

