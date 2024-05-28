package com.alisson.estruturadados.uesb.atividadesuesb.atividadetestarclassenode;

public class Teste {
    public static void main(String[] args) {
        Node<String> raiz = new Node<>("O");

        raiz.inserirOrdenado("H");
        raiz.inserirOrdenado("J");
        raiz.inserirOrdenado("I");
        raiz.inserirOrdenado("D");
        raiz.inserirOrdenado("E");
        raiz.inserirOrdenado("A");
        raiz.inserirOrdenado("K");
        raiz.inserirOrdenado("Q");
        raiz.inserirOrdenado("T");
        raiz.inserirOrdenado("P");
        raiz.inserirOrdenado("Z");
        raiz.inserirOrdenado("X");

        raiz.imprimeInOrdem();
        System.out.println();

        raiz.imprimeInOrdem2();
        System.out.println();

        raiz.imprimeEmPreordem();
        System.out.println();

        raiz.imprimeEmPosordem();
        System.out.println();

        raiz.imprimeEmLargura();

        raiz.imprimeEmLarguraInvertido();
        System.out.println();


        System.out.println(+ raiz.calculaAltura());

        System.out.println(raiz.calculaAlturaEmLargura());

        System.out.println(raiz.pesquisarValor("X").getValor());
//        System.out.println(raiz.pesquisarValor("B").getValor());

        System.out.println(raiz.calculaTotalNodes());

        System.out.println(raiz.calculaTotalNodesFolhas());

        raiz.removerNode("X", raiz.pesquisarValor("Z"));
        raiz.imprimeEmLargura();
        System.out.println();

        System.out.println(raiz.NodeComMaiorValor().getValor());
        System.out.println(raiz.NodeComMenorValor().getValor());

        System.out.println(raiz.acharPai(raiz.pesquisarValor("H")).getValor());

    }
}
