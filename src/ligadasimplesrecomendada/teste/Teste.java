package ligadasimplesrecomendada.teste;

import ligadasimplesrecomendada.ListaLigadaSimples;

public class Teste {
    public static void main(String[] args) {
        ListaLigadaSimples<Integer> lista = new ListaLigadaSimples<>();
        lista.adicionar(1);
        System.out.println(lista);

        lista.adicionar(21);
        System.out.println(lista);

    }
}
