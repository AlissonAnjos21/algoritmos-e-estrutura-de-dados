package com.alisson.estruturadados.uesb.atividadesuesb.atividade7;

public interface Fila<T> {
    void fazVazia();
    boolean estaVazia();
    T getPrimeiro() throws ContainerVazioException, ListaVaziaException;
    void enfileirar(T elemento) throws ContainerCheioException;
    T desenfileirar() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
}
