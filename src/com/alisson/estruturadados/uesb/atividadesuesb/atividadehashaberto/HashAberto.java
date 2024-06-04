package com.alisson.estruturadados.uesb.atividadesuesb.atividadehashaberto;

public class HashAberto<K, V> {

    private static final int CAPACIDADE = 11;
    private K[] keys;
    private V[] values;
    private int size;
    private int capacidade;
    private FuncaoHash funcaoHash;

    public HashAberto(FuncaoHash funcaoHash) {
        this.funcaoHash = funcaoHash;
        this.capacidade = CAPACIDADE;
        this.keys = (K[]) new Object[capacidade];
        this.values = (V[]) new Object[capacidade];
    }

    //hash padrao, depois construir outras funções aqui com
    //hash linear, hash quadratico e o hash duplo
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacidade);
    }

    private int hashLinear(K key, int i){
        return Math.abs(((key.hashCode() % capacidade) + i) % capacidade);
    }

    private int hashQuadratico(K key, int i){
        return Math.abs(((key.hashCode() % capacidade) + (i * i)) % capacidade);
    }

    private int hashDuplo(K key, int i){
        return Math.abs(((key.hashCode() % capacidade) + i * (Math.abs(key.hashCode() % (capacidade - 1)) + 1)) % capacidade);
    }

    public void put(K key, V value) {
        int i = 0;
        int index;
        if(funcaoHash == FuncaoHash.PADRAO){
            index = hash(key);
        }else if(funcaoHash == FuncaoHash.LINEAR){
            index = hashLinear(key, i);
        }else if(funcaoHash == FuncaoHash.QUADRATICO){
            index = hashQuadratico(key, i);
        }else{
            index = hashDuplo(key, i);
        }

        while (keys[index] != null) { //nulo é a informação que nunca foi usada
            if (keys[index].equals(key)) {
                values[index] = value; // Atualiza o valor se a chave já existir
                return;
            }
            i++;
            if(funcaoHash == FuncaoHash.PADRAO){
                index = (index + 1) % capacidade;
            }else if(funcaoHash == FuncaoHash.LINEAR){
                index = hashLinear(key, i);
            }else if(funcaoHash == FuncaoHash.QUADRATICO){
                index = hashQuadratico(key, i);
            }else{
                index = hashDuplo(key, i);
            }
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % capacidade;
        }
        return null; // Retorna null se a chave não for encontrada
    }

    public V remove(K key) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                V value = values[index];
                keys[index] = null;
                values[index] = null;
                size--;
                return value;
            }
            index = (index + 1) % capacidade;
        }
        return null; // Retorna null se a chave não for encontrada
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}