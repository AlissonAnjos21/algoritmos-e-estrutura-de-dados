package com.alisson.estruturadados.uesb.atividadesuesb.atividadehashdeenderecamentofechadocomarvoreavl;

public class Teste {
    public static void main(String[] args) {
        //ha um erro que eu nao consegui arrumar dado o tempo



        int M = 13; // Exemplo de tamanho da tabela hash
        MeuHash hF = new MeuHash(M);
        hF.inserir("Helio");
        hF.inserir("jose");
        hF.inserir("Jose");
        hF.inserir("Antonio");
        hF.inserir("Roberto");
        hF.inserir("Hugo");

        hF.imprimirTabelaHash();
    }
}
