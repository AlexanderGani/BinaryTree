import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Alex Gani
 * @version: 4/21/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for (int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        //use recursion in order to search
        //plug in root Node and value
        return searcher(root, val);
    }


    /**
     * A helper function of search that searches through tree to see if val is present
     * @param node to compare int val to
     * @param val integer to search for
     * @return if node(val) is present in tree
     */
    private boolean searcher(BSTNode node, int val) {
        // if the node is null, stop recursion and return false
        if (node == null) {
            return false;
        }
        // if the node is val (aka val is in the tree) return true
        if (node.getVal() == val) {
            return true;
        }
        // if val is less than node, call method recursively, inputting the left node
        if (val < node.getVal()) {
            return searcher(node.getLeft(), val);
        }
        // else, call method recursively and input right
        else {
            return searcher(node.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        // create array list to return
        ArrayList<BSTNode> arr = new ArrayList<>();
        //call helper method
        Inorder(root, arr);
        return arr;
    }

    /**
     * A helper function of getInorder to return nodes in order
     * @param node node that we will add to array if it is not null
     * @param arr arr list which we add nodes to
     */
    private void Inorder(BSTNode node, ArrayList<BSTNode> arr) {
        // same as previous, if node is null return
        if (node == null) {
            return;
        }
        // call recursively, because we are returning left to right start with left, then root, then right
        Inorder(node.getLeft(), arr);
        arr.add(node);
        Inorder(node.getRight(), arr);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // create array list to return
        ArrayList<BSTNode> arr = new ArrayList<>();
        // call helper method
        Preorder(root, arr);
        return arr;
    }

    /**
     * helper method of getPreorder which returns the tree in pre order
     * @param node we add this to array list and return it in pre order if it is not nul
     * @param arr array list we add the nodes to
     */
    private void Preorder(BSTNode node, ArrayList<BSTNode> arr) {
        // if node is null, return
        if (node == null) {
            return;
        }
        // since this is preorder, we start by adding root to arr, then left, then right, using recursion
        arr.add(node);
        Preorder(node.getLeft(), arr);
        Preorder(node.getRight(), arr);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // create array list to return
        ArrayList<BSTNode> arr = new ArrayList<>();
        // call helper method
        Postorder(root, arr);
        return arr;
    }

    /**
     * helper method of getPostorder which returns the nodes in post order (left-right-root)
     * @param node node which we add to array list if not null
     * @param arr array list containing nodes in post order which we return
     */
    private void Postorder(BSTNode node, ArrayList<BSTNode> arr) {
        // if node equals null, return
        if (node == null) {
            return;
        }
        // since this is post order we recursively call left, then right, then add root
        Postorder(node.getLeft(), arr);
        Postorder(node.getRight(), arr);
        arr.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        // using recursion we set root to the node helper method returns when given root and val as input
        root = inserter(root, val);
    }

    /**
     * helper method to insert which takes a value and inserts a node w/ that value into the tree if it doesnt exist already
     * @param node node that we compare our values to in order to see where we are (e.g if val is larger or smaller node val
     * @param val val of node that we want to insert into the tree
     * @return either new node containing val (if it doesn't exist in tree already) or unchanged node (if it already exists)
     */
    private BSTNode inserter(BSTNode node, int val) {
        // if node is null this means that the value should exist at this point, meaning we insert node(val) here
        if (node == null) {
            return new BSTNode(val);
        }
        // if val is less than node, use recursion on left node
        if (val < node.getVal()) {
            node.setLeft(inserter(node.getLeft(), val));
        }
        // if val is greater than node, use recursion on right node
        else if (val > node.getVal()) {
            node.setRight(inserter(node.getRight(), val));
        }
        // return node with no modifications because it already exists in tree
        return node;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
