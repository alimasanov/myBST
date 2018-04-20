package com.company;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bST = new BinarySearchTree();
        bST.insert(12);
        bST.insert(60);
        bST.insert(4);
        bST.insert(-2);
        bST.insert(40);
        bST.insert(3);
        int value = -11;
        Node foundValue = bST.search(value);
        if(foundValue != null){
            System.out.println("Value " + foundValue.key + " is found");
        }
        else
            System.out.println("We can't find: " + value);
        bST.inOrderTraverseTree(bST.root);
        System.out.println();
        bST.preOrderTraverseTree(bST.root);
        System.out.println();
        bST.postOrderTraverseTree(bST.root);
        System.out.println();
        bST.delete(40);
        bST.delete(3);
        bST.inOrderTraverseTree(bST.root);
    }
}
