package com.alisson.estruturadados.uesb.atividadesuesb.atividade7;

public interface Deque<T> {
    void fazVazia();
    boolean estaVazia();
    T getPrimeiro() throws ContainerVazioException, ListaVaziaException;
    T getUltimo() throws ContainerVazioException, ListaVaziaException;
    void enfileirarInicio(T elemento);
    void enfileirarFim(T elemento);
    T desenfileirarInicio() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
    T desenfileirarFim() throws ContainerVazioException, ListaVaziaException, ObjetoNaoEncontradoException;
}
