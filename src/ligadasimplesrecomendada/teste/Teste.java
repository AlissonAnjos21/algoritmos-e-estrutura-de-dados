package ligadasimplesrecomendada.teste;

import ligadasimplesrecomendada.ListaLigadaSimples;

public class Teste {
    public static void main(String[] args) {
        ListaLigadaSimples<Integer> lista = new ListaLigadaSimples<>();
        lista.adicionar(1);
        System.out.println(lista);

        lista.adicionar(21);
        System.out.println(lista);

        lista.adicionar(42);
        System.out.println(lista);

        lista.adicionar(63);
        System.out.println(lista);

        System.out.println("BUSCAR POR POSICAO: ");
//        System.out.println(lista.buscarPorPosicao(0));
//        System.out.println(lista.buscarPorPosicao(1));
//        System.out.println(lista.buscarPorPosicao(2));
//        System.out.println(lista.buscarPorPosicao(3));
//        System.out.println(lista.buscarPorPosicao(4)); // Nao existe

        System.out.println("BUSCAR POR ELEMENTO: ");
        System.out.println(lista.buscarPorElemento(63));
        System.out.println(lista.buscarPorElemento(42));
        System.out.println(lista.buscarPorElemento(21));
        System.out.println(lista.buscarPorElemento(1));
        System.out.println(lista.buscarPorElemento(1024));

        lista.limpar();
        System.out.println(lista);

    }
}
