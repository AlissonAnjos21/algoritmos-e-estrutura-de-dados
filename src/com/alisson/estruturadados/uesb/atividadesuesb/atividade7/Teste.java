package com.alisson.estruturadados.uesb.atividadesuesb.atividade7;

public class Teste {
    public static void main(String[] args) throws Exception{
        DequeLista<Integer> deque = new DequeLista<>();

        System.out.println(deque);

        deque.enfileirarInicio(1);
        deque.enfileirarInicio(2);
        System.out.println(deque);

        deque.enfileirarFim(-1);
        deque.enfileirarFim(-2);
        System.out.println(deque);

        System.out.println(deque.getPrimeiro());
        System.out.println(deque.getUltimo());

        System.out.println(deque.estaVazia());

        System.out.println(deque.desenfileirarInicio());
        System.out.println(deque);

        System.out.println(deque.desenfileirarFim());
        System.out.println(deque);

        deque.fazVazia();
        System.out.println(deque);
    }
}
