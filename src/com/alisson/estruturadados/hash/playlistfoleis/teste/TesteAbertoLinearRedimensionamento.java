package com.alisson.estruturadados.hash.playlistfoleis.teste;

import com.alisson.estruturadados.hash.playlistfoleis.hashabertolinearredimensionamento.HashAbertoLinear;

public class TesteAbertoLinearRedimensionamento {
    public static void main(String[] args) {
        HashAbertoLinear hash = new HashAbertoLinear(2);
        hash.inserir(21, 21);
        hash.inserir(42, 42);
        hash.imprimir();
        System.out.println();

        hash.inserir(63, 63);
        hash.inserir(84, 84);
        hash.imprimir();

    }
}
