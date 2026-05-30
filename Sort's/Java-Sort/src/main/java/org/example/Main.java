package org.example;

import java.util.Arrays;

// --- SELECTION SORT ---
class SelectionSort {
    // Complexidade de Tempo: O(n^2) em todos os casos.
    public void sort(int[] array) {
        int n = 10; // Limite fixo de 10 elementos
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

// --- INSERTION SORT ---
class InsertionSort {
    // Complexidade de Tempo: O(n^2) no pior caso, O(n) no melhor caso (ja ordenado).
    public void sort(int[] array) {
        int n = 10; // Limite fixo de 10 elementos
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}

// --- SHELL SORT ---
class ShellSort {
    // Complexidade de Tempo: O(n log n) a O(n^1.5) dependendo dos "gaps".
    public void sort(int[] array) {
        int n = 10; // Limite fixo de 10 elementos

        // Aqui estao os GAPS! Começamos com a metade do array (5) e vamos dividindo.
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                // Compara os elementos separados pelo "gap"
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}

// --- MERGE SORT ---
class MergeSort {
    // Complexidade de Tempo: O(n log n) em todos os casos.
    public void sort(int[] array) {
        // Limitando a chamada inicial para os 10 primeiros elementos (indices 0 a 9)
        mergeSort(array, 0, 9);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle); // Metade esquerda
            mergeSort(array, middle + 1, right); // Metade direita
            merge(array, left, middle, right); // Junta tudo ordenado
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = array[left + i];
        for (int j = 0; j < n2; ++j) R[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { array[k] = L[i]; i++; k++; }
        while (j < n2) { array[k] = R[j]; j++; k++; }
    }
}

// --- QUICK SORT ---
class QuickSort {
    // Complexidade de Tempo: O(n log n) na media, O(n^2) no pior caso.
    public void sort(int[] array) {
        // Limitando a chamada inicial para os 10 primeiros elementos (indices 0 a 9)
        quickSort(array, 0, 9);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high); // Pega o indice do pivo
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

public class Main {
    public static void main(String[] args) {

        int[] dadosBase = {4, 6, 9, 13, 10, 1, 5, 2, 8, 7};

        System.out.println("=== TESTANDO OS ALGORITMOS DE ORDENACAO ===");
        System.out.println("Array Original: " + Arrays.toString(dadosBase) + "\n");

        // Testando Selection Sort
        int[] cloneSelection = dadosBase.clone();
        new SelectionSort().sort(cloneSelection);
        System.out.println("Selection Sort: " + Arrays.toString(cloneSelection));

        // Testando Insertion Sort
        int[] cloneInsertion = dadosBase.clone();
        new InsertionSort().sort(cloneInsertion);
        System.out.println("Insertion Sort: " + Arrays.toString(cloneInsertion));

        // Testando Shell Sort
        int[] cloneShell = dadosBase.clone();
        new ShellSort().sort(cloneShell);
        System.out.println("Shell Sort:     " + Arrays.toString(cloneShell));

        // Testando Merge Sort
        int[] cloneMerge = dadosBase.clone();
        new MergeSort().sort(cloneMerge);
        System.out.println("Merge Sort:     " + Arrays.toString(cloneMerge));

        // Testando Quick Sort
        int[] cloneQuick = dadosBase.clone();
        new QuickSort().sort(cloneQuick);
        System.out.println("Quick Sort:     " + Arrays.toString(cloneQuick));
    }
}