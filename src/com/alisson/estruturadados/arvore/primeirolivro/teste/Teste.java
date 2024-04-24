package com.alisson.estruturadados.arvore.primeirolivro.teste;

import com.alisson.estruturadados.arvore.primeirolivro.BinarySearchTree;

public class Teste {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(11);
        tree.insert(7);
        tree.insert(15);
        tree.insert(5);
        tree.insert(3);
        tree.insert(9);
        tree.insert(8);
        tree.insert(10);
        tree.insert(13);
        tree.insert(12);
        tree.insert(14);
        tree.insert(20);
        tree.insert(18);
        tree.insert(25);
        tree.insert(6);

        tree.inOrderTraverse();
        System.out.println();
        tree.preOrderTraverser();
        System.out.println();
        tree.postOrderTraverser();
        System.out.println();
        System.out.println();
        System.out.println("Min = " + tree.min().getKey());
        System.out.println("Max = " + tree.max().getKey());

    }
}
