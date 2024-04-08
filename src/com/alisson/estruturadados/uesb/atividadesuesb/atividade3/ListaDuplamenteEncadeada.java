package com.alisson.estruturadados.uesb.atividadesuesb.atividade3;

public class ListaDuplamenteEncadeada<T> {
    private Element<T> head;
    private Element<T> tail;

    public final class Element<T>{
        T data;
        Element<T> prev;
        Element<T> next;

        public Element(T data, Element<T> prev, Element<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

    }

    public void inserirInicio(T item){
        Element<T> temp = new Element<>(item, null, this.head);
        if(this.head == null){
            this.tail = temp;
        }else{
            this.head.prev = temp;
        }
        this.head = temp;
    }

    public void inserirFim(T item){
        Element<T> temp = new Element<>(item, this.tail, null);
        if(this.head == null){
            this.head = temp;
        }else{
            this.tail.next = temp;
        }
        this.tail = temp;
    }

}
