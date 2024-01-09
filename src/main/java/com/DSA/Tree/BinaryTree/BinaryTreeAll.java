package com.DSA.Tree.BinaryTree;


// Binary tree Create(Insert) and Search and Same tree problem solved
class BSTNode{
    int data;
    BSTNode childLeft;
    BSTNode childRight;

    public BSTNode(int key) {
        data = key;
        childLeft = childRight = null;
    }

}
public class BinaryTreeAll {


    static BSTNode root;
    static BSTNode root1;
    public BinaryTreeAll() {
        root = null;
    }

    public BSTNode insert(BSTNode node, int data){

        if (node == null) {
            node = new BSTNode(data);
        }else{
            if(data < node.data){
                node.childLeft = insert(node.childLeft, data);
            }else{
               node.childRight = insert(node.childRight,data);
            }
        }
        return node;
    }


    public void printTree(BSTNode node, String prefix){
        if(node == null){
            return;
        }
        System.out.println(prefix + " + " + node.data);
        printTree(node.childLeft , prefix + " ");
        printTree(node.childRight , prefix + " ");
    }

    public boolean searchTree(BSTNode node, int val){
        boolean found = false;
        while((node!=null) && !found) {
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

    public static void main(String[] args) {


        BinaryTreeAll bTree = new BinaryTreeAll();

        root = bTree.insert(root, 55);
        root = bTree.insert(root, 20);
        root = bTree.insert(root, 90);
        root = bTree.insert(root, 80);
        root = bTree.insert(root, 50);
        root = bTree.insert(root, 35);
        root = bTree.insert(root, 15);
        root = bTree.insert(root, 65);
        bTree.printTree(root," ");
        System.out.println(bTree.searchTree(root,35));

        BinaryTreeAll bTree1 = new BinaryTreeAll();

        root1 = bTree1.insert(root1, 55);
        root1 = bTree1.insert(root1, 90);
        root1 = bTree1.insert(root1, 80);
        root1 = bTree1.insert(root1, 50);
        root1 = bTree1.insert(root1, 35);
        root1 = bTree1.insert(root1, 15);
        root1 = bTree1.insert(root1, 75);
        bTree.printTree(root1," ");
        System.out.println(bTree.searchTree(root1,35));
        System.out.println("Is Identical : "+ isIdenticalTree(bTree.root,bTree1.root1));

    }

    private static boolean isIdenticalTree(BSTNode root, BSTNode root1) {

        if(root == null && root1 == null) return true;
        if(root !=null && root1 != null){
            return ((root.data == root1.data) && isIdenticalTree(root.childLeft,root1.childLeft)
                    && isIdenticalTree(root.childRight,root1.childRight));
        }
        return false;
    }


}

