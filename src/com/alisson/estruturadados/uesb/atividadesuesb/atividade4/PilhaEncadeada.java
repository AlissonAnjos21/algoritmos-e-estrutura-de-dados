package com.alisson.estruturadados.uesb.atividadesuesb.atividade4;

public class PilhaEncadeada<T> implements IPilha<T>{
    private ListaEncadeada<T> lista;
    private int count;

    public PilhaEncadeada(){
        this.lista = new ListaEncadeada<>();
        this.count = 0;
    }

    public void fazVazia(){
        this.lista.fazVazia();
        this.count = 0;
    }

    public boolean estaVazia(){
        return count == 0;
    }

    public void push(T item){
        this.lista.inserirInicio(item);
        this.count++;
    }

    public T pop() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException{
        if(this.count == 0){
            throw new ContainerVazioException("Container Vazio");
        }

        T resultado = lista.getPrimeiro();
        this.lista.extrair(resultado);
        this.count--;

        return resultado;
    }

    public T getTop() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException{
        if(this.count == 0){
            throw new ContainerVazioException("Container Vazio");
        }
        return lista.getPrimeiro();
    }

}
