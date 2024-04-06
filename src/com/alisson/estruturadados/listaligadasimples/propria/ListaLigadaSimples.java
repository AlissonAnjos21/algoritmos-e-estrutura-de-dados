package com.alisson.estruturadados.listaligadasimples.propria;

public class ListaLigadaSimples<T> {

    private No<T> head;
    private No<T> tail;
    private int tamanho = 0;

    public ListaLigadaSimples(No<T> elemento){
        this.head = elemento;
        this.tail = elemento;
    }

    public ListaLigadaSimples(){
        this.head = null;
        this.tail = null;
    }

    public void adicionarFinal(No<T> elemento){
        if(this.tamanho > 0){
            this.tail.setProximo(elemento);
        }else{
            this.head = elemento;
        }
        this.tail = elemento;
        this.tamanho++;
    }

    public void adicionarInicio(No<T> elemento){
        if(this.tamanho > 0){
          elemento.setProximo(this.head);
        }else{
            this.tail = elemento;
        }
        this.head = elemento;
        this.tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "ListaEncadeadaSimples{" +
                "\nhead=" + head +
                ",\ntail=" + tail +
                ",\ntamanho=" + tamanho +
                "}";
    }
}