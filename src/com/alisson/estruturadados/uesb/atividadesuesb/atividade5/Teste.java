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

    }
}
