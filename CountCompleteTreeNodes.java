package competitiveProgramming;
import java.util.*;



class BinaryTree {
    static class Node {
        Node left, right;
        int value;
        public Node (int item) {
            value = item;
            left = null;
            right = null;
        }
    }

    public void addRecursive(Node current, int value) {
        if (value < current.value) {
            if (current.left != null)
                addRecursive(current.left, value);
            else
                current.left = new Node(value);
        }
        else if (value > current.value) {
            if(current.right != null)
                addRecursive(current.right, value);
            else
                current.right = new Node(value);
        }
    }

    public int countCompleteTreeNodesRecursively(Node root) {
        if (root == null)
            return 0;

        int res = 0;
        if (root.left != null && root.right != null)
            res++;
        res += countCompleteTreeNodesRecursively(root.left) + countCompleteTreeNodesRecursively(root.right);
        return res;
    }

        public int countCompleteTreeNodes(Node root) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node out = q.poll();

            if (out.right!=null && out.left!=null)
                count++;

            if (out.left!=null)
                q.add(out.left);
            if (out.right!=null)
                q.add(out.right);
        }

        return count++;
    }
}

public class CountCompleteTreeNodes {


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = new BinaryTree.Node(5);
        bt.addRecursive(root, 6);
        bt.addRecursive(root, 4);
        bt.addRecursive(root, 2);
        bt.addRecursive(root, 1);
        bt.addRecursive(root, 9);
        bt.addRecursive(root, 8);
        bt.addRecursive(root, 3);
        bt.addRecursive(root, 11);

//        System.out.println("Number of Complete Tree Nodes are: " + bt.countCompleteTreeNodes(root));
        System.out.println("Number of Complete Tree Nodes are: " + bt.countCompleteTreeNodesRecursively(root));
    }

}
