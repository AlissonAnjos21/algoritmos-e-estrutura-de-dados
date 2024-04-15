package com.alisson.estruturadados.uesb.atividadesuesb.atividade8;

public class ListaClassificadaEncadeada<T> implements ListaClassificada<T>{

    private ListaEncadeada<T> lista;
    private int count;

    public ListaClassificadaEncadeada(){
        this.lista = new ListaEncadeada<>();
        this.count = 0;
    }

    protected class MeuCursor implements Cursor<T>{
        ListaEncadeada<T>.Element elemento;

        public MeuCursor(ListaEncadeada<T>.Element elemento){
            this.elemento = elemento;
        } //fim MeuCursor

        public T getDado(){
            return this.elemento.getData();
        } //fim getDado

        public void inserirDepois(T elemento){
            this.elemento.inserirDepois(elemento);
            count++;
        } //fim inserirDepois

        public void inserirAntes(T elemento){
            this.elemento.inserirAntes(elemento);
            count++;
        } //fim inserirAntes

        public void remover() throws ObjetoNaoEncontradoException{
            lista.extrair(this.elemento.getData());
            count--;
        } //fim remover
    } //fim MeuCursor

    public void inserir(T elemento){
        this.lista.inserirFim(elemento);
        this.count++;
    } //fim inserir

    public T get(int indice){
        if(indice < 0 || indice > this.count){
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        ListaEncadeada<T>.Element ptr = this.lista.getHead();
        for(int i = 0; i < indice && ptr != null; i++){
            ptr = ptr.getNext();
        }
        return ptr.getData();
    } //fim get

    public boolean eMembro(T elemento){
        ListaEncadeada<T>.Element ptr;
        for(ptr = this.lista.getHead(); ptr != null; ptr = ptr.getNext()){
            if(ptr.getData() == elemento){
                return true;
            }
        }
        return false;
    } //fim eMembro

    public T procurar(T elemento){
        ListaEncadeada<T>.Element ptr;
        for(ptr = this.lista.getHead(); ptr != null; ptr = ptr.getNext()){
            T temporario = ptr.getData();
            if (ptr.getData().equals(elemento)) {
                return temporario;
            }
        }
        return null;
    } //fim procurar

    public void remover(T elemento) throws ContainerVazioException, ObjetoNaoEncontradoException{
        if(this.count == 0){
            throw new ContainerVazioException("A lista está vazia");
        }
        this.lista.extrair(elemento);
        this.count--;
    } //fim remover

    public Cursor<T> procurarPosicao(T elemento){
        ListaEncadeada<T>.Element ptr;
        for(ptr = this.lista.getHead(); ptr != null; ptr = ptr.getNext()){
            T temporario = ptr.getData();
            if(temporario.equals(elemento)){
                break;
            }
        }
        return new MeuCursor(ptr);
    } //fim procurarPosicao

    @Override
    public String toString(){
        return this.lista.toString();
    } //fim toString

} //fim ListaClassificadaEncadeada
