package com.alisson.estruturadados.uesb.atividadesuesb.atividade7;

public class DequeLista<T> extends FilaLista<T> implements Deque<T>{

    public DequeLista(){
        super();
    } //fim DequeLista

    public T getUltimo() throws ContainerVazioException, ListaVaziaException {
        if(this.count == 0){
            throw new ContainerVazioException("A fila está vazia");
        }
        return this.lista.getUltimo();
    } //fim getUltimo

    public void enfileirarInicio(T elemento){
        this.enfileirar(elemento);
    } //fim enfileirarInicio

    public void enfileirarFim(T elemento){
        this.lista.inserirInicio(elemento);
        this.count++;
    } //fim enfileirarFim

    public T desenfileirarInicio() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException{
        return this.desenfileirar();
    } //fim desenfileirarInicio

    public T desenfileirarFim() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException{
        if(this.count == 0){
            throw new ContainerVazioException("A fila está vazia");
        }
        T temporario = this.lista.getUltimo();
        this.lista.extrair(temporario);
        --this.count;
        return temporario;
    } //fim desenfileirarFim

} //fim DequeLista
