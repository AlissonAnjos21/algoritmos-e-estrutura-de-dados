package com.alisson.estruturadados.listaduplamenteencadeada.propria;

public class No<T> {
    private T data;
    private No<T> next;
    private No<T> prev;

    public No(T data, No<T> next){
        this.data = data;
        this.next = next;
    }

    public No(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public No<T> getNext(){
        return this.next;
    }

    public void setNext(No<T> next){
        this.next = next;
    }

    public No<T> getPrev(){
        return this.prev;
    }

    public void setPrev(No<T> prev){
        this.prev = prev;
    }

}
