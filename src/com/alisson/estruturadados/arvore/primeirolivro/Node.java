package com.alisson.estruturadados.arvore.primeirolivro;

public class Node<T> {
    T key;
    Node<T> left;
    Node<T> right;

    public Node(T key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public T getKey(){
        return this.key;
    }

}
