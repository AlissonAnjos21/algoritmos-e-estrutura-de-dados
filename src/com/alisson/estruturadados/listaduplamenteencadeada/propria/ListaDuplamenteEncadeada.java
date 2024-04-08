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
        No<T> ptr = this.head;

        while(ptr != null && ptr.getData() != data){
            ptr = ptr.getNext();
        }

        if(ptr == null){ //Valor nao existe na lista
            System.out.println("Valor não encontrado");
        }else if(ptr.getNext() == null){ //Valor eh o ultimo da lista
            ptr.getPrev().setNext(null);
            this.tail = ptr.getPrev();
        }else if(ptr.getPrev() == null){ //Valor eh o primeiro da lista
            ptr.getNext().setPrev(null);
            this.head = ptr.getNext();
        }else{ //Valor ta no meio da lista
            ptr.getPrev().setNext(ptr.getNext());
            ptr.getNext().setPrev(ptr.getPrev());
        }
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
