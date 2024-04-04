package ligadasimplespropria;

public class No<T> {
    private T elemento;
    private No<T> proximo;

    public No(T elemento){
        this.elemento = elemento;
        this.proximo = null;
    }


    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ",\nproximo=" + proximo +
                "}";
    }
}