package com.alisson.estruturadados.listaligadasimples.propria.teste;

import com.alisson.estruturadados.listaligadasimples.propria.ListaLigadaSimples;
import com.alisson.estruturadados.listaligadasimples.propria.No;

public class Teste {
    public static void main(String[] args) {
        ListaLigadaSimples<Integer> lista = new ListaLigadaSimples<>();

        No<Integer> no1 = new No<>(1);
        No<Integer> no2 = new No<>(2);
        No<Integer> no3 = new No<>(3);
        No<Integer> no4 = new No<>(4);
        No<Integer> no5 = new No<>(5);
        No<Integer> no6 = new No<>(6);
        No<Integer> no7 = new No<>(7);

        lista.adicionarInicio(no1);
        lista.adicionarInicio(no2);
        lista.adicionarInicio(no3);
        lista.adicionarFinal(no4);
        lista.adicionarFinal(no5);
        lista.adicionarFinal(no6);
        lista.adicionarInicio(no7);

        System.out.println(lista);

    }
}
