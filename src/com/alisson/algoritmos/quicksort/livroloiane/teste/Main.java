package com.alisson.algoritmos.quicksort.livroloiane.teste;

import com.alisson.algoritmos.quicksort.livroloiane.QuickSort;

public class Main {
    public static void main(String[] args) {
        int[] vetor = QuickSort.criarVetorAleatorio(21);
        QuickSort.imprimirVetor(vetor);

        QuickSort.quickSort(vetor);

        QuickSort.imprimirVetor(vetor);
    }
}
