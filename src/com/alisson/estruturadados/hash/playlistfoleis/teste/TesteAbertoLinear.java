package com.alisson.estruturadados.hash.playlistfoleis.teste;

import com.alisson.estruturadados.hash.playlistfoleis.hashabertolinear.HashAbertoLinear;

public class TesteAbertoLinear {
    public static void main(String[] args) {
        HashAbertoLinear hash = new HashAbertoLinear(10);

        hash.imprimir();
        System.out.println();

        hash.inserir(21, 21);
        hash.imprimir();
        System.out.println();

        hash.remover(21);
        hash.imprimir();
        System.out.println();

        hash.inserir(21, 21);
        hash.imprimir();

        System.out.println(hash.buscar(10));

    }
}
