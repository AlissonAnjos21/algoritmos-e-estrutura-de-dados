package com.alisson.estruturadados.uesb.atividadesuesb.atividade3;

public class ListaDuplamenteEncadeada<T> {
    private Element head;
    private Element tail;

    public final class Element{
        T data;
        Element prev;
        Element next;

        public Element(T data, Element prev, Element next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public void inserirAntes(T data){
            Element temp = new Element(data, this.prev, this);

            if(this == head){
                head = temp;
            }else{
                this.prev.next = temp;
            }
            this.prev = temp;
        }

        public void inserirDepois(T data){
            Element temp = new Element(data, this, this.next);

            if(this == tail){
                tail = temp;
            }else{
                this.next.prev = temp;
            }
            this.next = temp;
        }

    }

    public void inserirInicio(T item){
        Element temp = new Element(item, null, this.head);
        if(this.head == null){
            this.tail = temp;
        }else{
            this.head.prev = temp;
        }
        this.head = temp;
    }

    public void inserirFim(T item){
        Element temp = new Element(item, this.tail, null);
        if(this.head == null){
            this.head = temp;
        }else{
            this.tail.next = temp;
        }
        this.tail = temp;
    }

    public void remover(T item) throws ObjetoNaoEncontradoException{
        Element ptr = this.head;
        while(ptr != null && ptr.data != item){
            ptr = ptr.next;
        }

        if(ptr == null){
            throw new ObjetoNaoEncontradoException("Objeto não encontrado");
        }

        if(ptr == this.head){
            this.head = ptr.next;
            this.head.prev = null;
        }

        if(ptr == this.tail){
            this.tail = ptr.prev;
            this.tail.next = null;
        }else{
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
    }

    public Element getHead(){
        return this.head;
    }

    public Element getTail(){
        return this.tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListaDuplamenteEncadeada[");

        Element temp = this.head;
        while(temp != null){
            sb.append(temp.data);
            temp = temp.next;
            if(temp != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
