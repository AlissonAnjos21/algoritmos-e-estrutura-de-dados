package com.alisson.estruturadados.uesb.atividadesuesb.atividade8;

public interface Cursor<T> {
    T getDado();
    void inserirDepois(T elemento);
    void inserirAntes(T elemento);
    void remover() throws ObjetoNaoEncontradoException;
}
