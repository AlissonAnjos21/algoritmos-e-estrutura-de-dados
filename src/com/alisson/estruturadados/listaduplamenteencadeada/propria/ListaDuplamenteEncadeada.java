package com.alisson.estruturadados.listaduplamenteencadeada.propria;

public class ListaDuplamenteEncadeada<T> {
    private No<T> head;
    private No<T> tail;

    public ListaDuplamenteEncadeada(){
        this.head = null;
        this.tail = null;
    }

    public ListaDuplamenteEncadeada(T data){
        No<T> no = new No<T>(data);
        this.head = no;
        this.tail = no;
    }

    public void inserirInicio(T data){
        No<T> no = new No<>(data);
        no.setNext(this.head);
        if(this.head != null){
            this.head.setPrev(no);
        }else{
            this.tail = no;
        }
        this.head = no;
    }

    public void inserirFim(T data){
        No<T> no = new No<>(data);
        no.setPrev(this.tail);
        if(this.head != null){
            this.tail.setNext(no);
        }else{
            this.head = no;
        }
        this.tail = no;
    }

    public void remover(T data){

    }

    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("ListaDuplamenteEncadeada = [");

       No<T> atual = this.head;
       while(atual != this.tail){
           stringBuilder.append(atual.getData());
           stringBuilder.append(", ");
           atual = atual.getNext();
       }
       stringBuilder.append(this.tail.getData());
       stringBuilder.append("]");

       return stringBuilder.toString();
    }
}
