public class Binary_tree {
	
	

	    // Node class represents each node in the binary tree
	    static class Node {
	        int value;
	        Node left, right;

	        Node(int item) {
	            value = item;
	            left = right = null;
	        }
	    }

	    Node root;

	    // Constructor to initialize the binary tree
	    Binary_tree(int key) {
	        root = new Node(key);
	    }

	    // Insert method to add a node to the binary tree
	    void insert(int key) {
	        root = insertRec(root, key);
	    }

	    // A recursive function to insert a new key in BST
	    Node insertRec(Node root, int key) {
	        if (root == null) {
	            root = new Node(key);
	            return root;
	        }

	        if (key < root.value)
	            root.left = insertRec(root.left, key);
	        else if (key > root.value)
	            root.right = insertRec(root.right, key);

	        return root;
	    }

	    // Inorder traversal of the binary tree
	    void inorder() {
	        inorderRec(root);
	    }

	    // A utility function to do inorder traversal of BST
	    void inorderRec(Node root) {
	        if (root != null) {
	            inorderRec(root.left);
	            System.out.print(root.value + " ");
	            inorderRec(root.right);
	        }
	    }

	    // Search a node in the binary tree
	    boolean search(int key) {
	        return searchRec(root, key);
	    }

	    // A recursive function to search a key in BST
	    boolean searchRec(Node root, int key) {
	        if (root == null)
	            return false;
	        if (root.value == key)
	            return true;
	        return key < root.value ? searchRec(root.left, key) : searchRec(root.right, key);
	    }

	    public static void main(String[] args) {
	        Binary_tree tree = new Binary_tree(15);

	        // Insert elements into the binary tree
	        tree.insert(10);
	        tree.insert(20);
	        tree.insert(8);
	        tree.insert(12);
	        tree.insert(17);
	        tree.insert(25);

	        // Perform an inorder traversal (should print the elements in sorted order)
	        System.out.print("Inorder Traversal: ");
	        tree.inorder(); // Output: 8 10 12 15 17 20 25
	        System.out.println();

	        // Search for a few values in the binary tree
	        System.out.println("Search for 10: " + tree.search(10)); // Output: true
	        System.out.println("Search for 13: " + tree.search(13)); // Output: false
	        System.out.println("Search for 25: " + tree.search(25)); // Output: true
	        System.out.println("Search for 30: " + tree.search(30)); // Output: false
	    }
	}

