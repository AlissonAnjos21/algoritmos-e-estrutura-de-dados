package com.alisson.estruturadados.uesb.atividadesuesb.atividade4;

public class Teste {
    public static void main(String[] args) throws Exception{
        PilhaEncadeada<Integer> pilha = new PilhaEncadeada<>();
        pilha.push(21);
        System.out.println(pilha.getTop());

        pilha.push(42);
        System.out.println(pilha.getTop());

        System.out.println(pilha.estaVazia());

        pilha.pop();
        System.out.println(pilha.getTop());

        pilha.fazVazia();
        System.out.println(pilha.getTop()); //Erro

    }
}
