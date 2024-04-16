package com.alisson.estruturadados.uesb.atividadesuesb.atividade8;

public class Teste {
    public static void main(String[] args) throws Exception{

        ListaClassificadaEncadeada<Integer> lista = new ListaClassificadaEncadeada<>();
        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);
        lista.inserir(4);
        lista.inserir(5);

        System.out.println(lista);

        System.out.println(lista.eMembro(21));
        System.out.println(lista.eMembro(1));

        System.out.println(lista.procurar(5));
        System.out.println(lista.procurar(6));

        lista.inserir(21);
        System.out.println(lista);

        lista.remover(21);
        System.out.println(lista);

        System.out.println(lista.get(0));

        System.out.println(lista.procurarPosicao(1)); //retorná instância

        System.out.println(lista);

        lista.inserir(21);
        lista.inserir(13);
        lista.inserir(6);
        lista.inserir(7);

        System.out.println(lista);


    }
}
