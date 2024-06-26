package com.alisson.estruturadados.uesb.atividadesuesb.atividade5;

public interface Fila<T> {
    void fazVazia();
    boolean estaVazia();
    T getPrimeiro() throws ContainerVazioException, ListaVaziaException;
    void enfileirar(T elemento) throws ContainerCheioException;
    T desenfileirar() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
}
