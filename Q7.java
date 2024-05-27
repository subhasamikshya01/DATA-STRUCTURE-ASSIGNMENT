package Q7;
class BNode {
    int data;
    BNode left, right;

    public BNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class Q7 {
    private BNode root;

    public Q7() {
        this.root = null;
    }

    // Method to insert a node into the BST
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

    // Method to remove a node from the BST
    public void remove(int data) {
        root = removeRec(root, data);
    }

    private BNode removeRec(BNode root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = removeRec(root.left, data);
        } else if (data > root.data) {
            root.right = removeRec(root.right, data);
        } else {
            // Case 1: Node has no children
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node has two children
            else {
                // Find the successor (smallest node in the right subtree)
                root.data = minValue(root.right);

                // Delete the successor
                root.right = removeRec(root.right, root.data);
            }
        }

        return root;
    }

    private int minValue(BNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
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
        Q7 tree = new Q7();

        // Creating a binary search tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Printing inorder traversal of the BST before deletion
        System.out.println("Inorder traversal of the BST before deletion:");
        tree.inorder();

        // Removing node with data value 30 (Case 2: Node has one child)
        tree.remove(30);

        // Printing inorder traversal of the BST after deletion
        System.out.println("\nInorder traversal of the BST after deletion (Case 2):");
        tree.inorder();

        // Removing node with data value 70 (Case 3: Node has two children)
        tree.remove(70);

        // Printing inorder traversal of the BST after deletion
        System.out.println("\nInorder traversal of the BST after deletion (Case 3):");
        tree.inorder();

        // Removing node with data value 80 (Case 1: Node has no children)
        tree.remove(80);

        // Printing inorder traversal of the BST after deletion
        System.out.println("\nInorder traversal of the BST after deletion (Case 1):");
        tree.inorder();
    }
}
