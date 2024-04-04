package ligadasimplesrecomendada;

public class ListaLigadaSimples<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    public void adicionar(T elemento){
        No<T> no = new No<>(elemento);
        if(this.tamanho == 0){
            this.inicio = no;
        }else{
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
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
