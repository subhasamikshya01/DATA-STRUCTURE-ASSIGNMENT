package Q6;
class BNode {
    int data;
    BNode left, right;

    public BNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Q6 {
    private BNode root;

    public Q6() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BNode insertRec(BNode root, int data) {
        if (root == null) {
            root = new BNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Method to determine if the binary tree is a BST
    public boolean isBST() {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRec(BNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isBSTRec(node.left, min, node.data) && isBSTRec(node.right, node.data, max);
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

    // Main method for testing
    public static void main(String[] args) {
        Q6 tree = new Q6();

        // Creating a binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Printing inorder traversal of the tree
        System.out.println("Inorder traversal of the tree:");
        tree.inorder();

        // Checking if the binary tree is a BST
        System.out.println("\nIs the binary tree a BST?");
        System.out.println(tree.isBST());
    }
}
