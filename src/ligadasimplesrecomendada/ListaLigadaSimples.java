package ligadasimplesrecomendada;

public class ListaLigadaSimples<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    private int NAO_EXISTE = -1;

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
    public void limpar(){
        // Forma mais simples porem menos recomendada (questoes de optimizacao de memoria)
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
     */

    public void limpar(){
        for(No<T> atual = this.inicio; atual != null; ){ //intencionalmente deixado sem incremento
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    /*
    public T buscarPorPosicao(int posicao){
        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException();
        }

        if(posicao == 0){
            return this.inicio.getElemento();
        }

        int pos = 0;
        No<T> atual = this.inicio;
        while(pos < posicao){
            atual = atual.getProximo();
            pos++;
        }
        return atual.getElemento();
    }
     */

    public void buscarPorPosicao(int posicao){

    }

    public int buscarPorElemento(T elemento){
        int posicao = 0;
        for(No<T> atual = this.inicio; atual != null; ){
            if(atual.getElemento().equals(elemento)){
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }
        return NAO_EXISTE;
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
