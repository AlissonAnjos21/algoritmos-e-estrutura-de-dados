package com.alisson.estruturadados.uesb.atividadesuesb.atividade2;

public class ListaEncadeada {
    private Element head;
    private Element tail;

    public final class Element{
        Object data;
        Element next;

        public Element(Object data, Element next){
            this.data = data;
            this.next = next;
        }

        public Object getData(){
            return this.data;
        }

        public Element getNext(){
            return this.next;
        }

        public void inserirDepois(Object item){
            this.next = new Element(item, this.next);

            if(tail == this){
                tail = this.next;
            }
        }

        public void inserirAntes(Object item){
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

        @Override
        public String toString() {
            return "Element{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
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

    public Element getTail(){
        return this.tail;
    }

    public boolean estaVazia(){
        return (this.head == null);
    }

    public Object getPrimeiro() throws ListaVaziaException {
        if(this.head == null){
            throw new ListaVaziaException("A lista está vazia");
        }
        return this.head.data;
    }

    public Object getUltimo() throws ListaVaziaException{
        if(this.tail == null){
            throw new ListaVaziaException("A lista está vazia");
        }
        return this.tail.data;
    }

    public void inserirInicio(Object item){
        Element temp = new Element(item, this.head);
        if(this.head == null){
            this.tail = temp;
        }
        this.head = temp;
    }

    public void inserirFim(Object item){
        Element temp = new Element(item, null);
        if(this.head == null){
            this.head = temp;
        }else{
            this.tail.next = temp;
        }
        this.tail = temp;
    }

    public void atribuir(ListaEncadeada listaEncadeada){
        if(listaEncadeada != this){
            this.fazVazia();
            for(Element ptr = listaEncadeada.head; ptr != null; ptr = ptr.next){
                this.inserirFim(ptr.data);
            }
        }
    }

    public void extrair(Object item) throws ObjetoNaoEncontradoException {
        Element ptr = this.head;
        Element prevPtr = null;

        while(ptr != null && ptr.data != item){
            prevPtr = ptr;
            ptr = ptr.next;
        }

        if(ptr == null){
            throw new ObjetoNaoEncontradoException("Objeto não encontrado");
        }


        if(ptr == this.head){ // Caso em que o item está no head
            this.head = ptr.next;
        }else{
            prevPtr.next = ptr.next;
        }

        if(ptr == this.tail){
            prevPtr = this.tail;
        }
    }

    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
