package com.alisson.estruturadados.listaligadasimples.recomendada;

public class ListaLigadaSimples<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    private int NAO_EXISTE = -1;

    public void adicionarUltimo(T elemento){
        No<T> no = new No<>(elemento);
        if(this.tamanho == 0){
            this.inicio = no;
        }else{
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        this.tamanho++;
    }

    public void adicionarInicio(T elemento){
        No<T> no = new No<T>(elemento);
        if(this.tamanho == 0){
            this.ultimo = no;
        }else{
            no.setProximo(this.inicio);
        }
        this.inicio = no;
        this.tamanho++;
    }

    public void adicionarPosicao(int posicao, T elemento){
        if(posicao < 0 || posicao > this.tamanho){
            throw new IllegalArgumentException("Posicao invalida");
        }

        if(posicao == 0){
            this.adicionarInicio(elemento);
        }else if(posicao == this.tamanho){
            this.adicionarUltimo(elemento);
        }else{
            // Em uma posicao que nao eh o inicio nem o final (meio da lista)
            No<T> anterior = this.buscarNo(posicao-1);
            No<T> proximo = anterior.getProximo();
            No<T> no = new No<>(elemento);
            no.setProximo(proximo);
            anterior.setProximo(no);
            this.tamanho++;
        }
    }

    public T removerInicio(){
        if(this.tamanho == 0){
            throw new RuntimeException("A lista está vazia");
        }

        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if(this.tamanho == 0){
            this.ultimo = null;
        }
        return removido;
    }

    public T removerFinal(){
        if(this.tamanho == 0){
            throw new RuntimeException("A lista está vazia");
        }

        if(this.tamanho == 1){
            return this.removerInicio();
        }

        No<T> penultimoNo = this.buscarNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();

        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    private boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public T remover(int posicao){
        if(this.posicaoNaoExiste(posicao)){
            throw new IllegalArgumentException("A posição não existe");
        }

        if(posicao == 0){
            return this.removerInicio();
        }

        if(posicao == this.tamanho - 1){
            return this.removerFinal();
        }

        No<T> anterior = this.buscarNo(posicao - 1);
        No<T> atual = anterior.getProximo();
        No<T> proximo = atual.getProximo();

        anterior.setProximo(proximo);
        atual.setProximo(null);
        this.tamanho--;

        return atual.getElemento();
    }

    public int getTamanho(){
        return this.tamanho;
    }

    /*
    public void limpar(){
        // Forma mais simples porem menos recomendada (questoes de optimizacao de memoria)
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
     */

    public void limpar(){
        for(No<T> atual = this.inicio; atual != null; ){ //intencionalmente deixado sem incremento
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    /*
    public T buscarPorPosicao(int posicao){
        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException();
        }

        if(posicao == 0){
            return this.inicio.getElemento();
        }

        int pos = 0;
        No<T> atual = this.inicio;
        while(pos < posicao){
            atual = atual.getProximo();
            pos++;
        }
        return atual.getElemento();
    }
     */

    private No<T> buscarNo(int posicao){
        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posicao invalida");
        }
        No<T> atual = this.inicio;
        for(int i = 0; i < posicao; i++){
            atual = atual.getProximo();
        }
        return atual;
    }

    public T buscarPorPosicao(int posicao){
        return buscarNo(posicao).getElemento();
    }

    public int buscarPorElemento(T elemento){
        int posicao = 0;
        for(No<T> atual = this.inicio; atual != null; ){
            if(atual.getElemento().equals(elemento)){
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }
        return NAO_EXISTE;
    }

    /*
    @Override
    public String toString() {
        return "ListaLigadaSimples{" +
                "inicio=" + inicio +
                ", tamanho=" + tamanho +
                '}';
    }
     */

    /*
    @Override
    public String toString(){
        if(this.tamanho == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        No<T> atual = this.inicio;
        builder.append(atual.getElemento()).append(", ");
        while(atual.getProximo() != null){
            atual = atual.getProximo();
            builder.append(atual.getElemento()).append(", ");
        }
        return builder.toString();
    }
     */

    @Override
    public String toString(){
        if(this.tamanho == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;
        for(int i = 0; i < (this.tamanho - 1); i++){
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        return builder.toString();
    }
}
