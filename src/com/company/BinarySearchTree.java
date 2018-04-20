package com.company;

public class BinarySearchTree {
    public  Node root;


    public BinarySearchTree() {
        root = null;
    }
    public void inOrderTraverseTree(Node x) {
        if (x != null) {
            inOrderTraverseTree(x.left);
            System.out.print(x.key + "\t");
            inOrderTraverseTree(x.right);

        }
    }
    public void preOrderTraverseTree(Node x) {
        if (x != null) {
            System.out.print(x.key + "\t");
            preOrderTraverseTree(x.left);
            preOrderTraverseTree(x.right);
        }
    }
    public void postOrderTraverseTree(Node x) {
        if (x != null) {
            postOrderTraverseTree(x.left);
            postOrderTraverseTree(x.right);
            System.out.print(x.key + "\t");
        }
    }
    public Node search(int value){
        Node x = root;
        while(x!=null && x.key!=value){
            if(value < x.key)
                x = x.left;
            else
                x = x.right;
        }
        return x;
    }
    public boolean delete(int key) {
        Node x = root;
        Node parent = root;
        boolean isItALeftChild = true;
        while (x.key != key) {
            parent = x;
            if (key <= x.key) {
                isItALeftChild = true;
                x = x.left;
            } else {
                isItALeftChild = false;
                x = x.right;
            }
            if (x == null)
            return false;
        }
        if (x.left == null && x.right == null) {
            if (x == root)
            root = null;
            else if (isItALeftChild)
            parent.left = null;
            else
            parent.right = null;
        }
        else if (x.right == null) {
            if (x == root)
            root = x.left;
            else if (isItALeftChild)
            parent.left = x.left;
            else
            parent.right = x.left;
        }
        else if (x.left == null) {
            if (x == root)
            root = x.right;
            else if (isItALeftChild)
            parent.left = x.right;
            else
            parent.right = x.right;
        }
        else {
            Node replacement = getReplacementNode(x);
            if (x == root)
            root = replacement;
            else if (isItALeftChild)
            parent.left = replacement;
            else
            parent.right = replacement;
            replacement.left = x.left;
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node y = replacedNode.right;
        while (y != null) {
            replacementParent = replacement;
            replacement = y;
            y = y.left;
        }
        if (replacement != replacedNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = replacedNode.right;
        }
        return replacement;
    }

    private Node bstMinimum(Node x){
        while(x.left!=null)
            x = x.left;
        return x;
    }

//    private Node bstSuccessor(int value){
//        Node x = search(value);
//        if(x.right!=null)
//            return bstMinimum(x.right);
//        Node y = x.parent;
//        while(y!=null && x==y.right){
//            x = y;
//            y = y.parent;
//        }
//        return y;
//    }



    public void insert(int value) {
        Node z = new Node(value,null,null);
        if (root == null) {
            root = z;
        } else {
            Node x = root;
            Node y;
            while (true) {
                y = x;
                if (value <= x.key) {
                    x = x.left;
                    if (x == null) {
                        y.left = z;
                        return;
                    }
                } else {
                    x = x.right;
                    if (x == null) {
                        y.right = z;
                        return;
                    }
                }
            }
        }
    }


}
