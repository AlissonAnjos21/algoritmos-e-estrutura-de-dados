package com.alisson.estruturadados.uesb.atividadesuesb.atividadeimplementararvorebinariabusca;

public class ArvoreBinariaBusca<T> {

    Node<T> root;

    public ArvoreBinariaBusca(T valor){
        this.root = new Node<>(valor);
    }

}
