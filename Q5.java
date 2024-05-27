package Q5;

import java.util.LinkedList;
import java.util.Queue;

class BNode {
    int data;
    BNode left, right;

    public BNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Q5 {
    private BNode root;

    public Q5() {
        this.root = null;
    }

    // Method to create a BST from a sorted array
    public void createTree(int[] sortedArray) {
        root = createTreeRec(sortedArray, 0, sortedArray.length - 1);
    }

    private BNode createTreeRec(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BNode node = new BNode(sortedArray[mid]);

        node.left = createTreeRec(sortedArray, start, mid - 1);
        node.right = createTreeRec(sortedArray, mid + 1, end);

        return node;
    }

    // Inorder traversal of BST
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Level order traversal of BST
    public void levelOrder() {
        if (root == null) return;

        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BNode currentNode = queue.poll();
            System.out.print(currentNode.data + " ");

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Q5 tree = new Q5();

        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        tree.createTree(sortedArray);

        // Printing inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        tree.inorder();

        // Printing level order traversal of the BST
        System.out.println("\nLevel order traversal of the BST:");
        tree.levelOrder();
    }
}
