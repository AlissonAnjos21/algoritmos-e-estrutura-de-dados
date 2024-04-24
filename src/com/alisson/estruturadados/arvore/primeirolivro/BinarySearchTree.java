package com.alisson.estruturadados.arvore.primeirolivro;

import java.util.function.Consumer;

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

    private void insertNode(Node<T> node, T key){
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
            } //inserir na direita
        }
    } //fim insertNode

    public void inOrderTraverse(){
        this.inOrderTraverseNode(this.root);
    }

    private void inOrderTraverseNode(Node<T> node){
        if(node != null){
            this.inOrderTraverseNode(node.left);
            System.out.print(node.key + " ");
            this.inOrderTraverseNode(node.right);
        }
    }

    public void preOrderTraverser(){
        this.preOrderTraverseNode(this.root);
    }

    private void preOrderTraverseNode(Node<T> node){
        if(node != null){
            System.out.print(node.key + " ");
            this.preOrderTraverseNode(node.left);
            this.preOrderTraverseNode(node.right);
        }
    }

    public void postOrderTraverser(){
        this.postOrderTraverseNode(this.root);
    }

    private void postOrderTraverseNode(Node<T> node){
        if(node != null){
            this.postOrderTraverseNode(node.left);
            this.postOrderTraverseNode(node.right);
            System.out.print(node.key + " ");
        }
    }

}
