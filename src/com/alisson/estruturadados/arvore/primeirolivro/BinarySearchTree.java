package com.alisson.estruturadados.arvore.primeirolivro;

public class BinarySearchTree<T> {
    Node<T> root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(T key){
        if(this.root == null){
            this.root = new Node<>(key);
        }else{
            this.insertNode(this.root, key);
        }
    }

    public void insertNode(Node<T> node, T key){
        if(((Comparable<T>) key).compareTo(node.key) < 0){
            if(node.left == null){
                node.left = new Node<>(key);
            }else{
                this.insertNode(node.left, key);
            } //inserir na esquerda
        }else{
            if(node.right == null){
                node.right = new Node<>(key);
            }else{
                this.insertNode(node.right, key);
            }
        }
    } //fim insertNode

}
