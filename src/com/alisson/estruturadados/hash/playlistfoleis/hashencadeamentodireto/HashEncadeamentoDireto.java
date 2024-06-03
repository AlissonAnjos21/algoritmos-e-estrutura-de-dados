package com.alisson.estruturadados.hash.playlistfoleis.hashencadeamentodireto;

import java.util.LinkedList;

public class HashEncadeamentoDireto {
    private int m;
    private LinkedList<Elemento>[] tabelaHash;

    public HashEncadeamentoDireto(int m){
        this.m = m;
        for(int i = 0; i < this.m; i++){
            this.tabelaHash[i] = new LinkedList<Elemento>();
        }
    }

    private int calcularHash(int chave){
        return chave % this.m;
    }

    public LinkedList<Elemento> buscar(int chave){
        int h;
        h = this.calcularHash(chave);
        return this.tabelaHash[h];
    }

    public void inserir(int chave, int valor){
        int h;
        h = this.calcularHash(chave);
        this.tabelaHash[h].add(new Elemento(chave, valor));
    }

    public boolean remover(int chave){
        int h;
        h = this.calcularHash(chave);
        int tamanho = this.tabelaHash[h].size();
        for(int i = 0; i < tamanho; i++){
            if(this.tabelaHash[h].get(i).getChave() == chave){
                this.tabelaHash[h].remove(i);
                return true;
            }
        }
        return false;
    }

}
