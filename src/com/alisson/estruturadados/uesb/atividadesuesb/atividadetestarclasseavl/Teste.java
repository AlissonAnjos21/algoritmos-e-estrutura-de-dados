package com.alisson.estruturadados.uesb.atividadesuesb.atividadetestarclasseavl;

public class Teste {
    public static void main(String[] args) {
        AVL<Integer> avl = new AVL<>(50);
        avl.InsereOrdenado(1, null);
        avl.InsereOrdenado(64, null);
        avl.InsereOrdenado(12, null);
        avl.InsereOrdenado(18, null);
        avl.InsereOrdenado(66, null);
        avl.InsereOrdenado(38, null);
        avl.InsereOrdenado(95, null);
        avl.InsereOrdenado(58, null);
        avl.InsereOrdenado(59, null);
        avl.InsereOrdenado(70, null);
        avl.InsereOrdenado(68, null);
        avl.InsereOrdenado(39, null);
        avl.InsereOrdenado(62, null);
        avl.InsereOrdenado(7, null);
        avl.InsereOrdenado(60, null);
        avl.InsereOrdenado(43, null);
        avl.InsereOrdenado(16, null);
        avl.InsereOrdenado(67, null);
        avl.InsereOrdenado(34, null);
        avl.InsereOrdenado(35, null);

        avl.imprimeEmLargura();
        System.out.println();

        avl.removerNode(50, null);
        avl.imprimeEmLargura();
        System.out.println();

        avl.removerNode(95, avl.acharPai(avl.pesquisarValor(95)));
        avl.imprimeEmLargura();
        System.out.println();

        avl.removerNode(70,  avl.acharPai(avl.pesquisarValor(70)));
        avl.imprimeEmLargura();
        System.out.println();

        avl.removerNode(60,  avl.acharPai(avl.pesquisarValor(60)));
        avl.imprimeEmLargura();
        System.out.println();

        avl.removerNode(35,  avl.acharPai(avl.pesquisarValor(35)));
        avl.imprimeEmLargura();
        System.out.println();

    }
}
