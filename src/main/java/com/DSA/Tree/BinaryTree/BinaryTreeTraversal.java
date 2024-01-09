package com.DSA.Tree.BinaryTree;


class TBSTNode{
    int data;
    TBSTNode left;
    TBSTNode right;

    public TBSTNode(int data){
        this.data = data;
        left=right=null;

    }
}
public class BinaryTreeTraversal {

    TBSTNode root;

    public static void main(String[] args) {
        BinaryTreeTraversal btree = new BinaryTreeTraversal();
        btree.root = btree.insert(btree.root,55);
        btree.root = btree.insert(btree.root,26);
        btree.root = btree.insert(btree.root,20);
        btree.root = btree.insert(btree.root,34);
        btree.root = btree.insert(btree.root,70);
        btree.root = btree.insert(btree.root,60);
        System.out.println("********* Inserted Order**********************************");
        System.out.println("55"+" "+"26"+" "+"20"+" "+"34"+" "+"70"+" "+"60");
        System.out.println("********* Pre-Order(root->left->right) *******************");
        btree.printPreOrder(btree.root, " ");
        System.out.println("\n*********** In-Order(left->root->right) *****************");
        btree.printInOrder(btree.root, " ");
        System.out.println("\n************* Post-Order (left-right-root) ***************");
        btree.printPostOrder(btree.root, " ");
    }

    private void printPostOrder(TBSTNode node, String prefix){
        if(node==null) return;
        printPostOrder(node.left," ");
        printPostOrder(node.right," ");
        System.out.print(node.data + " ");
    }
    private void printInOrder(TBSTNode node, String prefix) {
        if(node == null) return ;
        printInOrder(node.left," ");
        System.out.print(node.data + " ");
        printInOrder(node.right," ");
    }

    private void printPreOrder(TBSTNode node, String prefix) {

        if(node == null) return ;
        System.out.print(node.data + " ");
        printPreOrder(node.left,prefix+" ");
        printPreOrder(node.right, prefix+" ");
    }

    private TBSTNode insert(TBSTNode node, int data) {

        if(node == null ){
            node = new TBSTNode(data);
        }
        else{
            if(data <= node.data){
                node.left   = insert(node.left,data);
            }else{
                node.right = insert(node.right,data);
            }
        }
        return node;
    }
}
