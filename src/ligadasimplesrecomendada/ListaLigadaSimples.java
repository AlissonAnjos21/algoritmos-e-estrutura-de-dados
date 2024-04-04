package ligadasimplesrecomendada;

public class ListaLigadaSimples<T> {
    private No<T> inicio;
    private int tamanho = 0;

    public void adicionar(T elemento){
        No<T> no = new No<>(elemento);
        this.inicio = no;
        this.tamanho++;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {
        return "ListaLigadaSimples{" +
                "inicio=" + inicio +
                ", tamanho=" + tamanho +
                '}';
    }
}
