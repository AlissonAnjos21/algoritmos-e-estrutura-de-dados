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

    /*
    @Override
    public String toString() {
        return "ListaLigadaSimples{" +
                "inicio=" + inicio +
                ", tamanho=" + tamanho +
                '}';
    }
     */

    /*
    @Override
    public String toString(){
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        No<T> atual = this.inicio;
        builder.append(atual.getElemento()).append(", ");
        while(atual.getProximo() != null){
            atual = atual.getProximo();
            builder.append(atual.getElemento()).append(", ");
        }
        return builder.toString();
    }
     */

    @Override
    public String toString(){
        if(this.tamanho == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;
        for(int i = 0; i < (this.tamanho - 1); i++){
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        return builder.toString();
    }
}
