package com.openx;

public class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value, Node leftChild, Node rightChild){
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }
}