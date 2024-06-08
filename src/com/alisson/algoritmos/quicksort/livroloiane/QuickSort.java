package com.alisson.algoritmos.quicksort.livroloiane;

import java.util.Random;

public class QuickSort {

    public static int[] quickSort(int[] vetor){
        return quick(vetor, 0, vetor.length - 1);
    }

    private static int[] quick(int[] vetor, int esquerda, int direita){
        int indice = particao(vetor, esquerda, direita);
        if(vetor.length > 1){
            if(esquerda < indice - 1){
                quick(vetor, esquerda, indice - 1);
            }
            if(indice < direita){
                quick(vetor, indice, direita);
            }
        }
        return vetor;
    }

    private static int particao(int[] vetor, int esquerda, int direita){
        int pivot = vetor[(int) (esquerda + direita)/2];
        int i = esquerda;
        int j = direita;
        while(i <= j){
            while(vetor[i] < pivot){
                i++;
            }
            while(vetor[j] > pivot){
                j--;
            }
            if(i <= j){
                int auxiliar = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = auxiliar;
                i++;
                j--;
            }
        }
        return i;
    }


    public static int[] criarVetorAleatorio(int tamanho){
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for(int i = 0; i < tamanho; i++){
            vetor[i] = random.nextInt(100);
        }
        return vetor;
    }

    public static void imprimirVetor(int[] vetor){
        int tamanho = vetor.length;
        for(int i = 0; i < tamanho; i++){
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

}
