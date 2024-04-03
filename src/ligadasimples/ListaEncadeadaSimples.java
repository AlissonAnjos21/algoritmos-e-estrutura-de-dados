package ligadasimples;

public class ListaEncadeadaSimples<T> {
    private No<T> elemento;
    private int tamanho = 0;

    public ListaEncadeadaSimples(No<T> elemento){
        this.elemento = elemento;
        this.tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }
}
