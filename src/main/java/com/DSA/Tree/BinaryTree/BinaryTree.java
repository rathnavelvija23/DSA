package com.DSA.Tree.BinaryTree;

// Binary tree Create(Insert) and Search and Same tree problem solved
class Node {
    int data;
    Node childLeft;
    Node childRight;

    public Node(int key) {
        data = key;
        childLeft = childRight = null;
    }
}

public class BinaryTree {

    static Node root;
    static Node root1;



    /**
     * Inserts a new node with the given data into the binary tree.
     */
    public Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data < node.data) {
                node.childLeft = insert(node.childLeft, data);
            } else {
                node.childRight = insert(node.childRight, data);
            }
        }
        return node;
    }

    /**
     * Prints the binary tree using a pre-order traversal.
     */
    public void printTree(Node node, String prefix) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + " + " + node.data);
        printTree(node.childLeft, prefix + " ");
        printTree(node.childRight, prefix + " ");
    }

    /**
     * Searches for a specific value in the binary tree.
     *
     */
    public boolean searchTree(Node node, int val) {
        boolean found = false;
        while ((node != null) && !found) {
            int nodeVal = node.data;
            if (val < nodeVal)
                node = node.childLeft;
            else if (val > nodeVal)
                node = node.childRight;
            else {
                found = true;
                break;
            }
        }

        return found;
    }

    /**
     * Checks whether two binary trees are identical.
     */
    private static boolean isIdenticalTree(Node root, Node root1) {
        if (root == null && root1 == null) return true;
        if (root != null && root1 != null) {
            return ((root.data == root1.data) && isIdenticalTree(root.childLeft, root1.childLeft)
                    && isIdenticalTree(root.childRight, root1.childRight));
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();

        root = bTree.insert(root, 55);
        bTree.printTree(root, " ");
        System.out.println(bTree.searchTree(root, 35));

        BinaryTree bTree1 = new BinaryTree();

        root1 = bTree1.insert(root1, 55);
        root1 = bTree1.insert(root1,20);
        bTree1.printTree(root1, " ");
        System.out.println(bTree1.searchTree(root1, 35));
        System.out.println("Is Identical : " + isIdenticalTree(bTree.root, bTree1.root1));
    }
}
