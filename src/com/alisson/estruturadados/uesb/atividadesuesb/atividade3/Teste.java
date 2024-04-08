package com.alisson.estruturadados.uesb.atividadesuesb.atividade3;

public class Teste {
    public static void main(String[] args) throws ObjetoNaoEncontradoException{
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();

        lista.inserirFim(3);
        lista.inserirInicio(2);
        lista.inserirInicio(1);
        lista.inserirFim(4);
        lista.inserirFim(21);
        System.out.println(lista);

        lista.remover(21);
        System.out.println(lista);

        lista.getHead().inserirAntes(21);
        System.out.println(lista);

        lista.getTail().inserirAntes(42);
        System.out.println(lista);

        lista.getTail().inserirDepois(63);
        System.out.println(lista);

        lista.getHead().inserirDepois(0);
        System.out.println(lista);

        ListaDuplamenteEncadeada<String> listaString = new ListaDuplamenteEncadeada<>();
        listaString.inserirFim("três");
        listaString.inserirInicio("dois");
        listaString.inserirInicio("um");
        listaString.inserirFim("quatro");
        System.out.println(listaString);

        listaString.remover("quatro");
        System.out.println(listaString);

        listaString.getTail().inserirDepois("cinco");
        listaString.getHead().inserirAntes("zero");
        listaString.getTail().inserirAntes("quatro");
        listaString.getHead().inserirDepois("meio");
        System.out.println(listaString);

        listaString.remover("meio");
        System.out.println(listaString);

    }
}
