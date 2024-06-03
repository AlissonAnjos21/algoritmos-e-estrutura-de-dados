package com.alisson.estruturadados.hash.playlistfoleis.hashabertolinear;

public class HashAbertoLinear {
    private int m;
    private Elemento[] tabelaHash;

    public HashAbertoLinear(int m){
        this.m = m;
        this.tabelaHash = new Elemento[m];
        for(int i = 0; i < m; i++){
            this.tabelaHash[i] = new Elemento();
            this.tabelaHash[i].setEstado(Estado.LIVRE);
        }
    }

    private int calcularHash(int chave, int k){
        return ((chave % this.m) + k) % this.m;
    }

    public int inserir(int chave, int valor){
        int h, h_inicial;
        int k = 0;
        h_inicial = this.calcularHash(chave, k);
        h = h_inicial;
        while(this.tabelaHash[h].getEstado() == Estado.OCUPADO){
            if(this.tabelaHash[h].getChave() == chave){
                break;
            }
            k++;
            h = this.calcularHash(chave, k);
            if(h == h_inicial){
                return -1; //circulou a tebela toda e nao foi possivel inserir
            }
        }
        this.tabelaHash[h].setChave(chave);
        this.tabelaHash[h].setValor(valor);
        this.tabelaHash[h].setEstado(Estado.OCUPADO);
        return h;
    }

    public int buscar(int chave){

        int h, h_inicial;
        int k = 0;
        h_inicial = this.calcularHash(chave, k);
        h = h_inicial;
        while(this.tabelaHash[h].getEstado() != Estado.LIVRE){
            if(this.tabelaHash[h].getEstado() == Estado.OCUPADO && this.tabelaHash[h].getChave() == chave){
                return h;
            }
            k++;
            h = this.calcularHash(chave, k);
            if(h == h_inicial){
                return -1;
            }

        }
        return -1;
    }

    public boolean remover(int chave){
        int h = this.buscar(chave);
        if(h != -1){
            this.tabelaHash[h].setEstado(Estado.APAGADO);
            return true;
        }
        return false;
    }

    public void imprimir(){
        for(int i = 0; i < m; i++){
            System.out.println(this.tabelaHash[i]);
        }
    }

}
