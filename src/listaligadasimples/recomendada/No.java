package listaligadasimples.recomendada;

public class No<T> {
    private T elemento;
    private No<T> proximo;

    public No(T elemento){
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(T elemento, No<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento(){
        return this.elemento;
    }

    public void setElemento(T elemento){
        this.elemento = elemento;
    }

    public void setProximo(No<T> proximo){
        this.proximo = proximo;
    }

    public No<T> getProximo(){
        return this.proximo;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }
}
