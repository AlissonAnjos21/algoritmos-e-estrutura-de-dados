package com.alisson.estruturadados.uesb.atividadesuesb.atividadehashaberto;

public class Teste {
    public static void main(String[] args) {
        HashAberto<Integer, Integer> hash = new HashAberto<>(FuncaoHash.PADRAO);
        hash.put(21, 21);
    }
}
