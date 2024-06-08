package com.alisson.algoritmos.quicksort.proprio;

import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] vetor){
        quick(vetor, 0, vetor.length - 1);
    }

    private static void quick(int[] vetor, int esquerda, int direita){
        int index = particao(vetor, esquerda, direita);
        if(vetor.length > 1){
            if(esquerda < index - 1){
                quick(vetor, esquerda, index - 1);
            }
            if(index < direita){
                quick(vetor, index, direita);
            }
        }
    }

    private static int particao(int[] vetor, int esquerda, int direita){
        int pivot = vetor[(int)(esquerda + direita)/2];
        int i = esquerda;
        int j = direita;
        while(i <= j){
            while(vetor[i] < pivot){
                i++;
            }
            while(pivot < vetor[j]){
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
