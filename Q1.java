class BSTNode {
    int info;
    BSTNode left, right;

    // Constructor
    public BSTNode(int info) {
        this.info = info;
        this.left = this.right = null;
    }
}
public class BinarySearchTree {
    private BSTNode root;

    // Constructor
    public BinarySearchTree() {
        this.root = null;
    }

    // Method to insert a node into the BST
    public void insert(int info) {
        root = insertRec(root, info);
    }

    // A recursive function to insert a new key in BST
    private BSTNode insertRec(BSTNode root, int info) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new BSTNode(info);
            return root;
        }

        // Otherwise, recur down the tree
        if (info < root.info) {
            root.left = insertRec(root.left, info);
        } else if (info > root.info) {
            root.right = insertRec(root.right, info);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Utility method to perform inorder traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    // A utility method to do inorder traversal of BST
    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.info + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print inorder traversal of the BST
        bst.inorder(); // Output will be: 20 30 40 50 60 70 80
    }
}
