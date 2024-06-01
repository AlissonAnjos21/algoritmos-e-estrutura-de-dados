package com.alisson.estruturadados.uesb.atividadesuesb.atividadehashdeenderecamentofechadocomarvoreavl;

import java.util.LinkedList;
import java.util.Queue;

public class MeuHash {
    protected AVL<String>[] tabelaHash ;
    protected int m;//m deve ser primo
    protected int qtd;

    public MeuHash(int m) {
        this.m = m;
        this.tabelaHash = new AVL[m];
        for(int i = 0; i < m; i++){
            tabelaHash[i] = null;
        }
    }

    public void inserir(String strk) {
        //calculei a minha função hash
        int entradahash = funcaohash(strk);
        //a entrada da tabela ja tem lista criada?
        if (tabelaHash[entradahash]==null) {
            tabelaHash[entradahash] = new AVL<>(strk);
        }else{
            tabelaHash[entradahash].inserirOrdenado(strk);
        }
        qtd++;
    }

    public boolean remover (String strk) {
        int entradahash = funcaohash(strk);
        boolean resultado = false;
        if (tabelaHash[entradahash]==null) {
            return resultado;
        }
        else {
            tabelaHash[entradahash].removerNode(strk, tabelaHash[entradahash]);
            resultado = true;
            this.qtd--;
            return resultado;
        }
    }
    public void alterarValor(String strKVelho, String strkNovo) {
        if (this.remover(strKVelho)) {
            this.inserir(strkNovo);
        }
    }

    private int funcaohash(String chave) {
        //minha função hash pode ser modificada
        int soma = 0;
        int comp = chave.length();

        for (int i = 0; i < comp; i++) {
            soma += (chave.charAt(i) * (i+1));
        }
        return (soma % m);

    }

    public boolean procurar(String strk){
        int entradahash = funcaohash(strk);
        if(tabelaHash[entradahash] != null){
            AVL<String> node = tabelaHash[entradahash];
            while(node != null){
                int comparacao = strk.compareTo(node.getValor());
                if(comparacao > 0){
                    node = node.getFilho_dir();
                }else if(comparacao < 0){
                    node = node.getFilho_esq();
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public void imprimirAVL(AVL<String> avl) {
        if(avl != null){
            Queue<AVL<String>> fila = new LinkedList<>();
            fila.add(avl);
            while(!fila.isEmpty()){
                AVL<String> node = fila.poll();
                System.out.print(node.getValor() + " ");
                if(node.getFilho_esq() != null){
                    fila.add(node.getFilho_esq());
                }
                if(node.getFilho_dir() != null){
                    fila.add(node.getFilho_dir());
                }
            }
            System.out.println();
        }
    }

    public void imprimirTabelaHash(){
        for(int i = 0; i < this.m; i++){
            System.out.println(i + ": ");
            if(tabelaHash[i] != null){
                this.imprimirAVL(tabelaHash[i]);
            }else{
                System.out.println("null");
            }
        }
    }

}