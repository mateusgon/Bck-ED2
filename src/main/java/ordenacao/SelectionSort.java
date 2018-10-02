package ordenacao;

import model.Resultado;

public class SelectionSort {

    public void ordena(Integer vetor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        Integer contador = 0;
        do {
            Integer menorIndice = contador;
            Integer contador2 = menorIndice + 1;
            while (contador2 < vetor.length) {
                if (vetor[menorIndice] > vetor[contador2]) {
                    menorIndice = contador2;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                contador2++;
            }
            Integer auxiliar = vetor[menorIndice];
            vetor[menorIndice] = vetor[contador];
            vetor[contador] = auxiliar;
            resultado.setNumTrocas(resultado.getNumTrocas() + 2);
            contador++;
        } while (contador < vetor.length);
        resultado.setTempoGasto(System.nanoTime()- tempoInicial);
    }
}
