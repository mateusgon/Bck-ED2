package ordenacao;

import model.Gasto;

public class QuickSort {

    private void quickSortObjeto(Gasto vetor[], int esq, int dir) {
        int i, j;
        Gasto pivo, aux;
        i = esq;
        j = dir - 1;
        pivo = vetor[(esq + dir) / 2];

        while (i <= j) {
            while (vetor[i].getReceipt_value() < pivo.getReceipt_value() && i < dir) {
                i++;
            }        
            while (vetor[j].getReceipt_value() > pivo.getReceipt_value() && j > esq) {
                j--;    
            }
            if (i <= j) {
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }
        if (j > esq) {
            quickSortObjeto(vetor, esq, j+1);
        }
        if (i < dir) {
            quickSortObjeto(vetor, i, dir);
        }
    }

    public long ordenaObjeto(Gasto vetor[]) {
        long tempoInicial = System.currentTimeMillis();
        quickSortObjeto(vetor, 0, vetor.length);
        return System.currentTimeMillis() - tempoInicial;
    }
    
    private void quickSortInteiro(Integer vetor[], int esq, int dir) {
        int i, j;
        Integer pivo, aux;
        i = esq;
        j = dir - 1;
        pivo = vetor[(esq + dir) / 2];

        while (i <= j) {
            while (vetor[i] < pivo && i < dir) {
                i++;
            }        
            while (vetor[j] > pivo && j > esq) {
                j--;    
            }
            if (i <= j) {
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
                i++;
                j--;
            }
        }
        if (j > esq) {
            quickSortInteiro(vetor, esq, j+1);
        }
        if (i < dir) {
            quickSortInteiro(vetor, i, dir);
        }
    }

    public long ordenaInteiro(Integer vetor[]) {
        long tempoInicial = System.currentTimeMillis();
        quickSortInteiro(vetor, 0, vetor.length);
        return System.currentTimeMillis() - tempoInicial;
    }
}