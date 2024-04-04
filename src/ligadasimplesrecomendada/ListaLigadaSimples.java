package ligadasimplesrecomendada;

public class ListaLigadaSimples<T> {
    private No<T> inicio;

    public void adicionar(T elemento){
        No<T> no = new No<>(elemento);
        this.inicio = no;
    }

    @Override
    public String toString() {
        return "ListaLigadaSimples{" +
                "inicio=" + inicio +
                '}';
    }
}
