package com.alisson.estruturadados.hash.playlistfoleis.hashabertolinear;

public class Elemento {
    private int chave;
    private int valor;
    private Estado estado;

    public int getChave(){
        return this.chave;
    }

    public void setChave(int chave){
        this.chave = chave;
    }

    public int getValor(){
        return this.valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public Estado getEstado(){
        return this.estado;
    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Elemento{");
        sb.append("chave=").append(chave);
        sb.append(", valor=").append(valor);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
}
