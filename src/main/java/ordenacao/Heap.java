package ordenacao;

import model.Resultado;

/**
 * Estrutura de dados para que seja realizado o HeapSort.
 * Sua implementação estará sendo explicada no relatório.
 * Possui como atributo um vetor de gastos e um tamanho que é o tamanho do vetor de gastos
 */

public class Heap {

    Integer gastos[];
    Integer tamanho;

    public Heap(Integer[] gastos) {
        this.gastos = gastos;
        this.tamanho = gastos.length;
    }

    public void refaz(Integer esquerda, Integer direita, Resultado resultado) {
        Integer indiceEsquerda = esquerda * 2;
        Integer valor = gastos[esquerda];
        while (indiceEsquerda <= direita) {
            if ((indiceEsquerda < direita) && (gastos[indiceEsquerda] < gastos[indiceEsquerda + 1])) {
                indiceEsquerda++;
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (indiceEsquerda >= tamanho || valor >= gastos[indiceEsquerda]) {
                break;
            }
            gastos[esquerda] = gastos[indiceEsquerda];
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            esquerda = indiceEsquerda;
            indiceEsquerda = esquerda * 2;
        }
        gastos[esquerda] = valor;
        resultado.setNumTrocas(resultado.getNumTrocas() + 1);
    }

    public void constroi(Resultado resultado) {
        Integer esquerda = this.tamanho / 2 + 1;
        while (esquerda > 1) {
            esquerda--;
            refaz(esquerda, tamanho, resultado);
        }
    }

}
