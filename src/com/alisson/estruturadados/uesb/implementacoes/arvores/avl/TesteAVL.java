package com.alisson.estruturadados.uesb.implementacoes.arvores.avl;

public class TesteAVL {
    public static void main(String[] args) {
        AVL<Integer> raiz = new AVL<>(50);

        raiz.insereOrdenado(1, raiz);

    }
}
