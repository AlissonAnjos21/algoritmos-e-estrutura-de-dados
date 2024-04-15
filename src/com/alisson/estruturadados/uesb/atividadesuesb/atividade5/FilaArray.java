package com.alisson.estruturadados.uesb.atividadesuesb.atividade5;

public class FilaArray<T> implements Fila<T> {

    T[] array;
    int head;
    int tail;
    int count;

    public FilaArray(int tamanho){
        this.array = (T[]) new Object[tamanho];
        this.head = 0;
        this.tail = tamanho - 1;
        this.count = 0;
    } //fim construtor

    public void fazVazia() {
        while(this.count > 0){
            this.array[this.head] = null;
            ++this.head;

            if(this.head == this.array.length){
                this.head = 0;
            }

            --this.count;
        }
    } //fim fazVazia

    public boolean estaVazia(){
        return (this.count == 0);
    } //fim estaVazia

    public T getPrimeiro() throws ContainerVazioException{
        if(this.count == 0){
            throw new ContainerVazioException("A fila está vazia");
        }
        return this.array[this.head];
    } //fim getPrimeiro

    public void enfileirar(T elemento) throws ContainerCheioException{
        if(this.count == this.array.length){
            throw new ContainerCheioException("A fila está cheia");
        }

        ++this.tail;
        if(this.tail == this.array.length){
            this.tail = 0;
        }

        this.array[this.tail] = elemento;
        ++this.count;
    } //fim enfileirar

    public T desenfileirar() throws ContainerVazioException{
        if(this.count == 0){
            throw new ContainerVazioException("A fila está vazia");
        }
        T resultado = this.array[this.head];
        this.array[this.head] = null;

        ++this.head;
        if(this.head == this.array.length){
            this.head = 0;
        }

        --this.count;

        return resultado;
    } //fim desenfileirar


} //fim FilaArray
