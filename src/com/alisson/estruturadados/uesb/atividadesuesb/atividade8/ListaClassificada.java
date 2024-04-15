package com.alisson.estruturadados.uesb.atividadesuesb.atividade8;

public interface ListaClassificada<T> {
    T get(int indice);
    Cursor<T> procurarPosicao(T elemento);
    boolean eMembro(T elemento);
    void inserir(T elemento);
    void remover(T elemento) throws ContainerVazioException, ObjetoNaoEncontradoException;
    T procurar(T elemento);
}
