package com.alisson.estruturadados.listaduplamenteencadeada.propria.teste;

import com.alisson.estruturadados.listaduplamenteencadeada.propria.ListaDuplamenteEncadeada;

public class Teste {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
        lista.inserirInicio(1);
        lista.inserirInicio(21);
        lista.inserirInicio(42);
        lista.inserirInicio(63);
        lista.inserirInicio(84);
        lista.inserirInicio(105);

        System.out.println(lista);

    }
}
