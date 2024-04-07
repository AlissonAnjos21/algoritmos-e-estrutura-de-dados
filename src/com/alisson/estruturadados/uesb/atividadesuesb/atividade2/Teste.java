package com.alisson.estruturadados.uesb.atividadesuesb.atividade2;

public class Teste {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirFim(21);
        lista.inserirInicio(42);
        lista.inserirFim(63);
        lista.inserirInicio(84);
        // 84 42 21 63

        System.out.println(lista);

    }
}
