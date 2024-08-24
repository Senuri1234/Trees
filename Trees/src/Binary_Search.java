
public class Binary_Search {
	
	

	    // Node class represents each node in the binary search tree
	    static class Node {
	        int value;
	        Node left, right;

	        // Constructor to create a new tree node
	        Node(int item) {
	            value = item;
	            left = right = null;
	        }
	    }

	    // Root of the BST
	    Node root;

	    // Constructor for the BST class to initialize the tree
	    Binary_Search() {
	        root = null;
	    }

	    // Method to insert a new key in the BST
	    void insert(int key) {
	        root = insertRec(root, key);
	    }

	    // A recursive function to insert a new key in the BST
	    Node insertRec(Node root, int key) {
	        // If the tree is empty, return a new node
	        if (root == null) {
	            root = new Node(key);
	            return root;
	        }

	        // Otherwise, recur down the tree
	        if (key < root.value) {
	            root.left = insertRec(root.left, key);
	        } else if (key > root.value) {
	            root.right = insertRec(root.right, key);
	        }

	        // Return the unchanged root pointer
	        return root;
	    }

	    // Method for inorder traversal of the BST
	    void inorder() {
	        inorderRec(root);
	    }

	    // A utility function to do inorder traversal of the BST
	    void inorderRec(Node root) {
	        if (root != null) {
	            inorderRec(root.left);
	            System.out.print(root.value + " ");
	            inorderRec(root.right);
	        }
	    }

	    // Method to search a given key in the BST
	    boolean search(int key) {
	        return searchRec(root, key);
	    }

	    // A recursive function to search a key in the BST
	    boolean searchRec(Node root, int key) {
	        // Base Cases: root is null or key is present at root
	        if (root == null) {
	            return false;
	        }
	        if (root.value == key) {
	            return true;
	        }

	        // Key is smaller than root's key, search in the left subtree
	        if (key < root.value) {
	            return searchRec(root.left, key);
	        }

	        // Key is larger than root's key, search in the right subtree
	        return searchRec(root.right, key);
	    }

	    // Method to delete a node from the BST
	    void delete(int key) {
	        root = deleteRec(root, key);
	    }

	    // A recursive function to delete a node from the BST
	    Node deleteRec(Node root, int key) {
	        // Base case: If the tree is empty
	        if (root == null) {
	            return root;
	        }

	        // Recur down the tree
	        if (key < root.value) {
	            root.left = deleteRec(root.left, key);
	        } else if (key > root.value) {
	            root.right = deleteRec(root.right, key);
	        } else {
	            // Node with the key to be deleted is found

	            // Node with only one child or no child
	            if (root.left == null) {
	                return root.right;
	            } else if (root.right == null) {
	                return root.left;
	            }

	            // Node with two children: Get the inorder successor (smallest in the right subtree)
	            root.value = minValue(root.right);

	            // Delete the inorder successor
	            root.right = deleteRec(root.right, root.value);
	        }

	        return root;
	    }

	    // Method to find the minimum value node in the BST
	    int minValue(Node root) {
	        int minv = root.value;
	        while (root.left != null) {
	            minv = root.left.value;
	            root = root.left;
	        }
	        return minv;
	    }

	    public static void main(String[] args) {
	    	Binary_Search bst = new Binary_Search();

	        // Insert elements into the binary search tree
	        bst.insert(15);
	        bst.insert(10);
	        bst.insert(20);
	        bst.insert(8);
	        bst.insert(12);
	        bst.insert(17);
	        bst.insert(25);

	        // Perform an inorder traversal (should print the elements in sorted order)
	        System.out.print("Inorder Traversal: ");
	        bst.inorder(); // Output: 8 10 12 15 17 20 25
	        System.out.println();

	        // Search for a few values in the binary search tree
	        System.out.println("Search for 10: " + bst.search(10)); // Output: true
	        System.out.println("Search for 13: " + bst.search(13)); // Output: false
	        System.out.println("Search for 25: " + bst.search(25)); // Output: true
	        System.out.println("Search for 30: " + bst.search(30)); // Output: false

	        // Delete a node with no children (leaf)
	        bst.delete(8);
	        System.out.print("Inorder Traversal after deleting 8: ");
	        bst.inorder(); // Output: 10 12 15 17 20 25
	        System.out.println();

	        // Delete a node with one child
	        bst.delete(12);
	        System.out.print("Inorder Traversal after deleting 12: ");
	        bst.inorder(); // Output: 10 15 17 20 25
	        System.out.println();

	        // Delete a node with two children
	        bst.delete(15);
	        System.out.print("Inorder Traversal after deleting 15: ");
	        bst.inorder(); // Output: 10 17 20 25
	    }
	}



