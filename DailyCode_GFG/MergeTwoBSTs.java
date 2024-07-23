package DailyCode_GFG;
import java.util.*;

//GFG :-      https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
//Question :- Merge two BST's
public class MergeTwoBSTs {
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        pushLeft(stack1, root1);
        pushLeft(stack2, root2);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<Node> stack;
            if (stack1.isEmpty()) {
                stack = stack2;
            } else if (stack2.isEmpty()) {
                stack = stack1;
            } else {
                stack = (stack1.peek().data <= stack2.peek().data) ? stack1 : stack2;
            }

            Node node = stack.pop();
            result.add(node.data);
            pushLeft(stack, node.right);
        }

        return result;
    }

    private void pushLeft(Stack<Node> stack, Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);

        MergeTwoBSTs solution = new MergeTwoBSTs();
        List<Integer> mergedList = solution.merge(root1, root2);
        System.out.println(mergedList);  // Output: [1, 2, 2, 3, 3, 4, 5, 6, 6, 7]
    }
}
