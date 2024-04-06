package com.alisson.estruturadados.listaligadasimples.recomendada.teste;

import com.alisson.estruturadados.listaligadasimples.recomendada.ListaLigadaSimples;

public class Teste {
    public static void main(String[] args) {
        ListaLigadaSimples<Integer> lista = new ListaLigadaSimples<>();
        lista.adicionarUltimo(1);
        System.out.println(lista);

        lista.adicionarUltimo(21);
        System.out.println(lista);

        lista.adicionarUltimo(42);
        System.out.println(lista);

        lista.adicionarUltimo(63);
        System.out.println(lista);

        System.out.println("BUSCAR POR ELEMENTO: ");
        System.out.println(lista.buscarPorElemento(63));
        System.out.println(lista.buscarPorElemento(42));
        System.out.println(lista.buscarPorElemento(21));
        System.out.println(lista.buscarPorElemento(1));
        System.out.println(lista.buscarPorElemento(1024));

        System.out.println("BUSCAR POR POSICAO: ");
        System.out.println(lista.buscarPorPosicao(0));
        System.out.println(lista.buscarPorPosicao(1));
        System.out.println(lista.buscarPorPosicao(2));
        System.out.println(lista.buscarPorPosicao(3));
//        System.out.println(lista.buscarPorPosicao(4)); // Nao existe

        lista.limpar();
        System.out.println(lista);

        lista.adicionarInicio(1);
        System.out.println(lista);

        lista.adicionarInicio(21);
        System.out.println(lista);

        lista.adicionarInicio(42);
        System.out.println(lista);

        lista.adicionarInicio(63);
        System.out.println(lista);

        lista.limpar();

        System.out.println("Adicionar em uma posicao: ");
        lista.adicionarPosicao(0, 1);
        lista.adicionarPosicao(1, 21);
        lista.adicionarPosicao(2, 63);
        lista.adicionarPosicao(2, 42);
//        lista.adicionarPosicao(5, 84); // Nao existe
        System.out.println(lista);

    }
}
