package com.alisson.estruturadados.uesb.atividadesuesb.atividade4;

public interface IPilha<T> {
    void fazVazia();
    boolean estaVazia();
    T getTop() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
    void push(T item);
    T pop() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
}
