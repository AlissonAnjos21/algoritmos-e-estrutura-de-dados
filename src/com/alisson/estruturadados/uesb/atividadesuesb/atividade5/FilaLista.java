package com.alisson.estruturadados.uesb.atividadesuesb.atividade5;

public class FilaLista<T> implements Fila<T>{
    private ListaEncadeada<T> lista;
    private int count;

    public FilaLista(){
        this.lista = new ListaEncadeada<>();
        this.count = 0;
    } //fim FilaEncadeada

    public void fazVazia(){
        this.lista.fazVazia();
        this.count = 0;
    } //fim fazVazia

    public boolean estaVazia(){
        return (this.count == 0);
    } //fim estaVazia

    public T getPrimeiro() throws ContainerVazioException, ListaVaziaException {
        if(this.count == 0){
            throw new ContainerVazioException("A fila está vazia");
        }
        return this.lista.getPrimeiro();
    } //fim getPrimeiro

    public void enfileirar(T elemento){
        this.lista.inserirFim(elemento);
        this.count++;
    } //fim enfileirar

    public T desenfileirar() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException{
        if(this.count == 0){
            throw new ContainerVazioException("A fila está vazia");
        }
        T temporario = this.lista.getPrimeiro();
        this.lista.extrair(temporario);
        --this.count;
        return temporario;
    } //fim desenfileirar

    @Override
    public String toString(){
        return this.lista.toString();
    }

} //fim FilaLista
