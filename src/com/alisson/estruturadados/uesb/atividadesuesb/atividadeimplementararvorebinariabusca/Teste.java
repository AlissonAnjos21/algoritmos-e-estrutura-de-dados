package com.alisson.estruturadados.uesb.atividadesuesb.atividadeimplementararvorebinariabusca;

public class Teste {
    public static void main(String[] args) {
        ArvoreBinariaBusca<String> arvore = new ArvoreBinariaBusca<>("E");

        arvore.root.inserirOrdenado("F");
        arvore.root.inserirOrdenado("A");
        arvore.root.inserirOrdenado("D");
        arvore.root.inserirOrdenado("B");
        arvore.root.inserirOrdenado("C");
        arvore.root.inserirOrdenado("I");
        arvore.root.inserirOrdenado("H");
        arvore.root.inserirOrdenado("G");

        arvore.root.imprimeEmPreordem();
        System.out.println();
        arvore.root.imprimeEmPosordem();
        System.out.println();
        arvore.root.imprimeEmLargura();

    }
}
