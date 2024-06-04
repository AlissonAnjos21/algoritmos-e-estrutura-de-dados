package com.alisson.estruturadados.hash.playlistfoleis.hashabertolinearredimensionamento;

public class HashAbertoLinear {
    private int m;
    private Elemento[] tabelaHash;
    private int n; //quantidade de elementos da tabela

    public HashAbertoLinear(int m){
        this.m = m;
        this.tabelaHash = new Elemento[m];
        for(int i = 0; i < m; i++){
            this.tabelaHash[i] = new Elemento();
            this.tabelaHash[i].setEstado(Estado.LIVRE);
        }
        this.n = 0;
    }

    private int calcularHash(int chave, int k){
        return ((chave % this.m) + k) % this.m;
    }

    public int inserir(int chave, int valor){
        int h, h_inicial;
        int k = 0;
        if(this.n > (this.m/2)){
            this.redimensionar(this.m*2);
        }
        h_inicial = this.calcularHash(chave, k);
        h = h_inicial;
        while(this.tabelaHash[h].getEstado() == Estado.OCUPADO){
            if(this.tabelaHash[h].getChave() == chave){
                this.n--;
                break;
            }
            k++;
            h = this.calcularHash(chave, k);
            if(h == h_inicial){
                return -1; //circulou a tebela toda e nao foi possivel inserir
            }
        }
        this.n++;
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
            this.n--;
            return true;
        }
        return false;
    }

    public void imprimir(){
        for(int i = 0; i < this.m; i++){
            System.out.println(this.tabelaHash[i]);
        }
    }

    private void redimensionar(int m_novo){
        Elemento[] tabelaAntiga = this.tabelaHash;
        int m_antigo = this.m;
        Elemento[] tabelaNova = new Elemento[m_novo];
        for(int i = 0; i < m_novo; i++){
            tabelaNova[i] = new Elemento();
            tabelaNova[i].setEstado(Estado.LIVRE);
        }
        this.tabelaHash = tabelaNova;
        this.m = m_novo;
        this.n = 0;
        for(int i = 0; i < m_antigo; i++){
            if(tabelaAntiga[i].getEstado() == Estado.OCUPADO){
                this.inserir(tabelaAntiga[i].getChave(), tabelaAntiga[i].getValor());
            }
        }
    }
}
