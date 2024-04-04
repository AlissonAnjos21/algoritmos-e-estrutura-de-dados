package ligadasimples.teste;

import ligadasimples.ListaEncadeadaSimples;
import ligadasimples.No;

public class Teste {
    public static void main(String[] args) {
        ListaEncadeadaSimples<Integer> lista = new ListaEncadeadaSimples<>();

        No<Integer> no1 = new No<>(21);
        No<Integer> no2 = new No<>(42);
        No<Integer> no3 = new No<>(63);

        lista.adicionarFinal(no1);
        lista.adicionarFinal(no2);
        lista.adicionarFinal(no3);

        System.out.println(lista);

    }
}
