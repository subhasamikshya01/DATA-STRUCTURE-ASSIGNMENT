class Country {
    private String name;
    private int population;

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{name='" + name + "', population=" + population + '}';
    }
}
class BNode {
    Country info;
    BNode left, right;

    public BNode(Country info) {
        this.info = info;
        this.left = this.right = null;
    }
}
public class Q3 {
    private BNode root;

    public Q3() {
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

    // A utility function to do inorder traversal of BST
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

    // Main method for testing
    public static void main(String[] args) {
        Q3 tree = new Q3();
        
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
    }
}
