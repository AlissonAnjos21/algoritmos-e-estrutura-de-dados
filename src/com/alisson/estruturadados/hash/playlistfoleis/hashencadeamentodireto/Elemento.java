package com.alisson.estruturadados.hash.playlistfoleis.hashencadeamentodireto;

public class Elemento {
    private int chave;
    private int valor;
    private int ocupado;

    public Elemento(){

    }

    public Elemento(int chave, int valor){
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return this.chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getOcupado() {
        return this.ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }
}
