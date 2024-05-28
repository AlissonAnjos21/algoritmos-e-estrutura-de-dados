package com.alisson.estruturadados.pilhaencadeada.propria;

public class ListaEncadeada<T> {

    Element head;
    Element tail;

    public class Element{
        T data;
        Element proximo;

        public Element(T data, Element proximo){
            this.data = data;
            this.proximo = proximo;
        }

        public T getData(){
            return this.data;
        }

        public Element getProximo(){
            return this.proximo;
        }
    }

    public ListaEncadeada(){
        this.head = null;
        this.tail = null;
    }

    public void inserirInicio(T elemento){
        Element temp = new Element(elemento, this.head);
        if(this.head == null){
            this.tail = temp;
        }
        this.head = temp;
    }

    public void inserirFim(T elemento){
        Element temp = new Element(elemento, null);
        if(this.head == null){
            this.head = temp;
        }else{
          this.tail.proximo = temp;
        }
        this.tail = temp;
    }

    public void extrair(T elemento){
        Element ptr = this.head;
        Element prevPtr = null;

        while(ptr != null && ptr.getData() != elemento){
            prevPtr = ptr;
            ptr = ptr.proximo;
        }

        if(ptr == null){
            throw new RuntimeException("Elemento não encontrado");
        }

        if(ptr == this.head){
            this.head = ptr.proximo;
        }else{
            prevPtr.proximo = ptr.proximo;
        }

        if(ptr == this.tail){
            this.tail = prevPtr;
        }

    }

}
