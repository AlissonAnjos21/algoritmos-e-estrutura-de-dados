package ligadasimples;

public class ListaEncadeadaSimples<T> {

    private No<T> head;
    private No<T> tail;
    private int tamanho = 0;

    public ListaEncadeadaSimples(No<T> elemento){
        this.head = elemento;
        this.tail = elemento;
    }

    public ListaEncadeadaSimples(){
        this.head = null;
        this.head = null;
    }

    public void adicionarFinal(No<T> elemento){
        if(this.tamanho > 0){
            this.tail.setProximo(elemento);
        }else{
            this.head = elemento;
        }
        this.tail = elemento;
        this.tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "ListaEncadeadaSimples{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                ",\ntamanho=" + tamanho +
                "}";
    }
}