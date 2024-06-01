package com.alisson.estruturadados.uesb.implementacoes.arvores.avl;

public class AVL<T> extends Node<T>{
    private int fatorBalanceamento;

    public AVL(T v){
        super(v);
        this.fatorBalanceamento = 0;
    }

    //o metodo getfilho é reescrito para retornar um node AVL
    public AVL<T> getFilho_dir() {
        return (AVL<T>)super.getFilho_dir();
    }

    //o metodo getfilho é reescrito para retornar um node AVL
    public AVL<T> getFilho_esq() {
        return (AVL<T>)super.getFilho_esq();
    }

    public int getFatorBalanceamento() {
        return this.fatorBalanceamento;
    }

    protected AVL<T> insereOrdenado(T v, AVL<T> noPai){
        int comparacao = v.toString().compareTo(noPai.getValor().toString());
        AVL<T> resultado;
        if(comparacao >= 0){ //v maior ou igual ao pai
            if(noPai.getFilho_dir() != null){
                this.getFilho_dir().insereOrdenado(v, this);
                resultado = this.verificarBalanceamento(noPai);
                return resultado;
            }else{
                this.filho_dir = new AVL<>(v); //como eh um no folha nao precisa verificar
            }
        }else{
            if(noPai.getFilho_esq() != null){
                this.getFilho_esq().insereOrdenado(v, this);
                resultado = this.verificarBalanceamento(noPai);
                return resultado;
            }else{
                this.filho_esq = new AVL<>(v); //como eh um no folha nao precisa verificar
            }
        }
        return this;
    }

    protected AVL<T> removerNode(T v, AVL<T> noPai){
        int comparacao = v.toString().compareTo(this.getValor().toString());
        AVL<T> resultado = this;
        if(comparacao > 0){ //valor eh maior
            return this.getFilho_dir().removerNode(v, this);
        }else if(comparacao < 0) { //valor eh menor
            return this.getFilho_esq().removerNode(v, this);
        }else{ //valor eh igual
            /*
            -Nao tem filho
            -Tem dois filhos
                +O no mais a esqueda do filho da direita nao possui filho a direita
                +O no mais a esqueda do filho da direita possui filho a direita
            -Tem um filho
             */

            if(this.getFilho_esq() == null && this.getFilho_dir() == null){
                if(noPai.getFilho_esq().getValor().equals(v)){
                    noPai.filho_esq = null;
                }else{
                    noPai.filho_dir = null;
                }
                resultado = noPai.verificarBalanceamento(noPai);
            }else if(this.getFilho_esq() != null && this.getFilho_dir() != null){




                //falta fazer isso, mas eu nao consigo hoje :(
                //de toda forma, eu nem sei se o resto ta certo





            }else{ //apenas um filho
                if(noPai.getFilho_esq().getValor().equals(v)){ //filho do pai pela esquerda
                    if(this.getFilho_esq() != null){ //o filho esta na esquerda
                        noPai.filho_esq = this.getFilho_esq();
                    }else{ //o filho esta na direita
                        noPai.filho_esq = this.getFilho_dir();
                    }
                }else{ //filho do pai pela direita
                    if(this.getFilho_esq() != null){
                        noPai.filho_dir = this.getFilho_esq();
                    }else{
                        noPai.filho_dir = this.getFilho_dir();
                    }
                }
                resultado = noPai.verificarBalanceamento(noPai);
            }
        }
        return resultado;
    }

    private int calcularFatorBalanceamento() {
        int alturaEsquerda = 0;
        int alturaDireita = 0;
        if(this.getFilho_esq() != null){
            alturaEsquerda = this.getFilho_esq().calculaAltura()+1;
        }
        if(this.getFilho_dir() != null){
            alturaDireita = this.getFilho_dir().calculaAltura()+1;
        }
        return alturaDireita - alturaEsquerda;
    }

    private AVL<T> verificarBalanceamento(AVL<T> noPai){
        int fb = this.calcularFatorBalanceamento();
        int fb1 = 0;

        //fb < -1: esta desbalanceado a esquerda
        //fb > 1: esta desbalanceado a direita
        if(fb < -1 || fb > 1){
            if(fb < -1){ //esta desbalanceado a esquerda
                if(this.getFilho_esq() != null){
                    fb1 = this.getFilho_esq().calcularFatorBalanceamento();
                }
                if(fb1 <= 0){ //esta desbalanceado a esquerda, entao uma rotacao simples a direita resolve
                    return this.rotacaoADireita(noPai);
                }
                return this.rotacaoDuplaADireita(noPai);
            }else{ //esta desbalanceado a direita
                if(this.getFilho_dir() != null){
                    fb1 = this.getFilho_dir().calcularFatorBalanceamento();
                }
                if(fb1 >= 0){
                    return this.rotacaoAEsquerda(noPai);
                }
                return this.rotacaoDuplaAEsquerda(noPai);
            }
        }
        return this;
    }

    public AVL<T> acharPai(Node<T> noRaiz){
        return (AVL<T>)super.acharPai(noRaiz);
    }

    private AVL<T> rotacaoAEsquerda(AVL<T> noPaiDesbalanceado){
        AVL<T> filhoDireita = noPaiDesbalanceado.getFilho_dir();
        noPaiDesbalanceado.filho_esq = filhoDireita.getFilho_esq();
        noPaiDesbalanceado.filho_dir = null;
        filhoDireita.filho_esq = noPaiDesbalanceado;
        return filhoDireita;
    }

    private AVL<T> rotacaoADireita(AVL<T> noPaiDesbalanceado){
        AVL<T> filhoEsquerda = noPaiDesbalanceado.getFilho_esq();
        noPaiDesbalanceado.filho_esq = filhoEsquerda.getFilho_dir();
        filhoEsquerda.filho_dir = noPaiDesbalanceado;
        return filhoEsquerda;
    }

    private AVL<T> rotacaoDuplaAEsquerda(AVL<T> noPaiDesbalanceado){
        noPaiDesbalanceado.filho_dir = noPaiDesbalanceado.rotacaoADireita(noPaiDesbalanceado.getFilho_dir());
        return noPaiDesbalanceado.rotacaoAEsquerda(noPaiDesbalanceado);
    }

    private AVL<T> rotacaoDuplaADireita(AVL<T> noPaiDesbalanceado){
        noPaiDesbalanceado.filho_esq = noPaiDesbalanceado.rotacaoAEsquerda(noPaiDesbalanceado.getFilho_esq());
        return noPaiDesbalanceado.rotacaoADireita(noPaiDesbalanceado);
    }

}
