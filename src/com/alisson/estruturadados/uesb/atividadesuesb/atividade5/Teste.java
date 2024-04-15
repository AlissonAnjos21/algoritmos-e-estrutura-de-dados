package com.alisson.estruturadados.uesb.atividadesuesb.atividade5;

public class Teste {
    public static void main(String[] args) throws Exception{

        //FilaArray
        System.out.println("FILA ARRAY: ");
        FilaArray<Integer> filaArray = new FilaArray<>(3);
        System.out.println(filaArray.estaVazia());

        filaArray.enfileirar(1);
        System.out.println(filaArray);

        filaArray.enfileirar(2);
        filaArray.enfileirar(3);
        System.out.println(filaArray);

        System.out.println("Desenfileirando...");
        System.out.println(filaArray.desenfileirar());
        System.out.println(filaArray);

        System.out.println(filaArray.getPrimeiro());

        filaArray.fazVazia();
        System.out.println(filaArray);

        //FilaEncadeada
        System.out.println("\nFILA ENCADEADA: ");
        FilaLista<Integer> filaLista = new FilaLista<>();

        System.out.println(filaLista.estaVazia());

        filaLista.enfileirar(1);
        filaLista.enfileirar(2);
        filaLista.enfileirar(3);
        System.out.println(filaLista);

        System.out.println(filaLista.getPrimeiro());

        System.out.println(filaLista.desenfileirar());
        System.out.println(filaLista);

        filaLista.fazVazia();
        System.out.println(filaLista);

    }
}
