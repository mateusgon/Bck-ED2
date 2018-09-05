package ordenacao;

import model.Gasto;

public class QuickSort {

    private void quickSort(Gasto vetor[], int esq, int dir) {
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
            quickSort(vetor, esq, j+1);
        }
        if (i < dir) {
            quickSort(vetor, i, dir);
        }
    }

    public long ordena(Gasto vetor[]) {
        Gasto vet[] = new Gasto[vetor.length];
        for (int i = 0; i < vetor.length; i++)
        {
            Gasto v = vetor[i];
            vet[i] = v;
        }
        long tempoInicial = System.currentTimeMillis();
        quickSort(vet, 0, vet.length);
        return System.currentTimeMillis() - tempoInicial;
    }
}