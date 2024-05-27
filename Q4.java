import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private BNode root;

    public BST() {
        this.root = null;
    }

    public void insert(Country country) {
        root = insertRec(root, country);
    }

    private BNode insertRec(BNode root, Country country) {
        if (root == null) {
            root = new BNode(country);
            return root;
        }

        if (country.getName().compareTo(root.info.getName()) < 0) {
            root.left = insertRec(root.left, country);
        } else if (country.getName().compareTo(root.info.getName()) > 0) {
            root.right = insertRec(root.right, country);
        }

        return root;
    }

    // Inorder traversal of BST
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.info);
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
            System.out.println(currentNode.info);

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    // Find node with maximum population
    public Country findMax() {
        if (root == null) return null;

        BNode maxNode = root;
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BNode currentNode = queue.poll();

            if (currentNode.info.getPopulation() > maxNode.info.getPopulation()) {
                maxNode = currentNode;
            }

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }

        return maxNode.info;
    }

    // Find node with minimum population
    public Country findMin() {
        if (root == null) return null;

        BNode minNode = root;
        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BNode currentNode = queue.poll();

            if (currentNode.info.getPopulation() < minNode.info.getPopulation()) {
                minNode = currentNode;
            }

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }

        return minNode.info;
    }

    // Main method for testing
    public static void main(String[] args) {
        BST tree = new BST();
        
        // Creating country objects
        Country usa = new Country("USA", 331000000);
        Country canada = new Country("Canada", 37700000);
        Country germany = new Country("Germany", 83000000);
        Country france = new Country("France", 67000000);
        Country japan = new Country("Japan", 126000000);

        // Inserting countries into BST
        tree.insert(usa);
        tree.insert(canada);
        tree.insert(germany);
        tree.insert(france);
        tree.insert(japan);

        // Printing inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        tree.inorder();

        // Printing level order traversal of the BST
        System.out.println("\nLevel order traversal of the BST:");
        tree.levelOrder();

        // Finding and printing the country with the maximum population
        System.out.println("\nCountry with the maximum population:");
        Country maxPopulationCountry = tree.findMax();
        System.out.println(maxPopulationCountry);

        // Finding and printing the country with the minimum population
        System.out.println("\nCountry with the minimum population:");
        Country minPopulationCountry = tree.findMin();
        System.out.println(minPopulationCountry);
    }
}
