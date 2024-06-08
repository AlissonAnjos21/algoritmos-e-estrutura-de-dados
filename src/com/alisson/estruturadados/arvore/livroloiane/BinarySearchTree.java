package com.alisson.estruturadados.arvore.livroloiane;

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

    public Node<T> min(){
        return this.minNode(this.root);
    }

    private Node<T> minNode(Node<T> node){
        Node<T> current = node;
        while(current != null && current.left != null){
            current = current.left;
        }
        return current;
    }

    public Node<T> max(){
        return this.maxNode(this.root);
    }

    private Node<T> maxNode(Node<T> node){
        Node<T> current = node;
        while(current != null && current.right != null){
            current = current.right;
        }
        return current;
    }

    public boolean search(T key){
        return this.searchNode(this.root, key);
    }

    private boolean searchNode(Node<T> node, T key){
        if(node == null){
            return false;
        }
        if(((Comparable<T>) key).compareTo(node.key) < 0){
            return this.searchNode(node.left, key);
        }else if(((Comparable<T>) key).compareTo(node.key) > 0){
            return this.searchNode(node.right, key);
        }else{
            return true;
        }
    }

    public void remove(T key){
        this.root = this.removeNode(this.root, key);
    }

    private Node<T> removeNode(Node<T> node, T key){
        if(node == null){
            return null;
        }
        if(((Comparable<T>) key).compareTo(node.key) < 0){
            node.left = this.removeNode(node.left, key);
            return node;
        }else if(((Comparable<T>) key).compareTo(node.key) > 0){
            node.right = this.removeNode(node.right, key);
            return node;
        }else{
            if(node.left == null && node.right == null){
                node = null;
                return node;
            }
            if(node.left == null){
                node = node.right;
                return node;
            }else if(node.right == null){
                node = node.left;
                return node;
            }
            Node<T> aux = this.minNode(node.right);
            node.key = aux.key;
            node.right = this.removeNode(node.right, aux.key);
            return node;

        }
    }

}
