package ordenacao;

import model.Resultado;

public class InsertionSort {

    public void ordena(Integer vetor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        Integer posicaoInicial = 1;
        do {
            Boolean aux = true;
            Integer valorASerComparado = vetor[posicaoInicial];
            int posicaoAtual = posicaoInicial;
            while (aux) {
                if ((posicaoAtual > 0)) {
                    if (vetor[posicaoAtual - 1] > valorASerComparado) {
                        vetor[posicaoAtual] = vetor[posicaoAtual - 1];
                        posicaoAtual--;
                        resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                    } else {
                        aux = false;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                } else {
                    aux = false;
                }
            }
            vetor[posicaoAtual] = valorASerComparado;
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            posicaoInicial++;
        } while (posicaoInicial < vetor.length);
        resultado.setTempoGasto(System.nanoTime()- tempoInicial);

    }
}
