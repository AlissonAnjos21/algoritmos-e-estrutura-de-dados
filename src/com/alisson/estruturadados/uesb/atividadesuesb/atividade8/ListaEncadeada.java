package com.alisson.estruturadados.uesb.atividadesuesb.atividade8;

public class ListaEncadeada<T> {
    private Element head;
    private Element tail;

    public final class Element{
        T data;
        Element next;

        public Element(T data, Element next){
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return this.data;
        }

        public Element getNext(){
            return this.next;
        }

        public void inserirDepois(T item){
            this.next = new Element(item, this.next);

            if(tail == this){
                tail = this.next;
            }
        }

        public void inserirAntes(T item){
            Element temp = new Element(item, this);
            if(this == head){
                head = temp;
            }else{
                Element prevPtr = head;
                while(prevPtr != null && prevPtr.next != this){
                    prevPtr = prevPtr.next;
                }
                prevPtr.next = temp;
            }
        }
    }

    public ListaEncadeada(){}

    public void fazVazia(){
        this.head = null;
        this.tail = null;
    }

    public Element getHead(){
        return this.head;
    }

    public void setHead(Element head){
        this.head = head;
    }

    public void setTail(Element tail){
        this.tail = tail;
    }

    public Element getTail(){
        return this.tail;
    }

    public boolean estaVazia(){
        return (this.head == null);
    }

    public T getPrimeiro() throws ListaVaziaException {
        if(this.head == null){
            throw new ListaVaziaException("A lista está vazia");
        }
        return this.head.data;
    }

    public T getUltimo() throws ListaVaziaException {
        if(this.tail == null){
            throw new ListaVaziaException("A lista está vazia");
        }
        return this.tail.data;
    }

    public void inserirInicio(T item){
        Element temp = new Element(item, this.head);
        if(this.head == null){
            this.tail = temp;
        }
        this.head = temp;
    }

    public void inserirFim(T item){
        Element temp = new Element(item, null);
        if(this.head == null){
            this.head = temp;
        }else{
            this.tail.next = temp;
        }
        this.tail = temp;
    }

    public void atribuir(ListaEncadeada<T> listaEncadeada){
        if(listaEncadeada != this){
            this.fazVazia();
            for(Element ptr = listaEncadeada.head; ptr != null; ptr = ptr.next){
                this.inserirFim(ptr.data);
            }
        }
    }

    public void extrair(T item) throws ObjetoNaoEncontradoException {
        Element ptr = this.head;
        Element prevPtr = null;

        while(ptr != null && ptr.data != item){
            prevPtr = ptr;
            ptr = ptr.next;
        }

        if(ptr == null){
            throw new ObjetoNaoEncontradoException("Objeto não encontrado");
        }


        if(ptr == this.head){
            this.head = ptr.next;
        }else{
            prevPtr.next = ptr.next;
        }

        if(ptr == this.tail){
            this.tail = prevPtr;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

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
