package ordenacao;

import model.Gasto;
import model.Resultado;

public class QuickSort {

    private void quickSortObjeto(Gasto vetor[], int esquerda, int direita, Resultado resultado) {
        Gasto pivo;
        pivo = vetor[(esquerda + direita) / 2];
        int esq = esquerda;
        int dir = direita - 1;
        while (esq <= dir) {
            Boolean auxiliar = true;
            Boolean auxiliar2 = true;
            while (auxiliar) {
                if (vetor[esq].getReceipt_value() < pivo.getReceipt_value() && esq < direita) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    esq++;
                } else {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    auxiliar = false;
                }
            }
            while (auxiliar2) {
                if (vetor[dir].getReceipt_value() > pivo.getReceipt_value() && dir > esquerda) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    dir--;
                } else {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    auxiliar2 = false;
                }
            }
            if (esq <= dir) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 3);
                Gasto aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
                esq++;
                dir--;
            }
        }

        if (esq < direita) {
            quickSortObjeto(vetor, esq, direita, resultado);
        }
        if (dir > esquerda) {
            quickSortObjeto(vetor, esquerda, dir + 1, resultado);
        }
    }

    public void ordenaObjeto(Gasto vetor[], Resultado resultado) {
        long tempoInicial = System.currentTimeMillis();
        quickSortObjeto(vetor, 0, vetor.length, resultado);
        resultado.setTempoGasto(System.currentTimeMillis() - tempoInicial);
    }

    private void quickSortInteiro(Integer vetor[], int esquerda, int direita, Resultado resultado) 
    {
        Integer pivo;
        pivo = vetor[(esquerda + direita) / 2];
        int esq = esquerda;
        int dir = direita - 1;
        while (esq <= dir) {
            Boolean auxiliar = true;
            Boolean auxiliar2 = true;
            while (auxiliar) {
                if (vetor[esq] < pivo && esq < direita) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    esq++;
                } else {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    auxiliar = false;
                }
            }
            while (auxiliar2) {
                if (vetor[dir] > pivo && dir > esquerda) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    dir--;
                } else {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    auxiliar2 = false;
                }
            }
            if (esq <= dir) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 3);
                Integer aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
                esq++;
                dir--;
            }
        }
        if (esq < direita) {
            quickSortInteiro(vetor, esq, direita, resultado);
        }
        if (dir > esquerda) {
            quickSortInteiro(vetor, esquerda, dir + 1, resultado);
        }
    }

    public void ordenaInteiro(Integer vetor[], Resultado resultado) {
        long tempoInicial = System.currentTimeMillis();
        quickSortInteiro(vetor, 0, vetor.length, resultado);
        resultado.setTempoGasto(System.currentTimeMillis() - tempoInicial);
    }
}
