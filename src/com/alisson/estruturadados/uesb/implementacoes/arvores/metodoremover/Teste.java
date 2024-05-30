package com.alisson.estruturadados.uesb.implementacoes.arvores.metodoremover;

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
        raiz.inserirOrdenado("W");

        raiz.imprimeEmPosordem();
        System.out.println();

        Node<String> filho1 = raiz.pesquisarValor("D");
        Node<String> pai1 = raiz.acharPai(filho1);
        raiz.remover("D", pai1);

        raiz.imprimeEmLargura();
        System.out.println();

        Node<String> filho2 = raiz.pesquisarValor("Q");
        Node<String> pai2 = raiz.acharPai(filho2);
        raiz.remover("Q", pai2);
        raiz.imprimeEmLargura();

    }
}
