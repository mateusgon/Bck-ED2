package ordenacao;

import model.Resultado;

/**
 * Classe responsável por ordenar a heap
 * Estará sendo explicada em detalhes no relatório
 */

public class HeapSort {

    public void ordena(Integer vetor[], Integer n, Resultado resultado) {
        long tempoInicial = System.nanoTime();
        Heap h = new Heap(vetor);
        Integer direita;
        h.constroi(resultado);
        for (direita = n - 1; direita > 1; direita--) {
            Integer valor = vetor[1];
            vetor[1] = vetor[direita];
            vetor[direita] = valor;
            resultado.setNumTrocas(resultado.getNumTrocas() + 2);
            direita--;
            h.refaz(1, direita, resultado);
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }
}
