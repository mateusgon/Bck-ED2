package ordenacao;

import model.Resultado;

public class MergeSort {

    public void ordena(Integer vetor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        mergeSortInteiro(vetor, 0, vetor.length, resultado);
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public void mergeSortInteiro(Integer vetor[], Integer limiteInferior, Integer limiteSuperior, Resultado resultado) {
        if (limiteInferior < limiteSuperior) {
            Integer meio = ((limiteInferior + limiteSuperior) / 2);
            mergeSortInteiro(vetor, limiteInferior, meio, resultado);
            mergeSortInteiro(vetor, meio + 1, limiteSuperior, resultado);
            merge(vetor, limiteInferior, meio, limiteSuperior, resultado);
        }
    }

    public void merge(Integer vetor[], Integer limiteInferior, Integer meio, Integer limiteSuperior, Resultado resultado) {

        Integer vetorAuxiliar[] = new Integer[vetor.length];
        Integer limiteInferiorAux = limiteInferior;
        Integer meioAux = meio;
        Integer contador = 0;

        do {
            if (vetor[limiteInferiorAux] < vetor[meioAux]) {
                vetorAuxiliar[contador] = vetor[limiteInferiorAux];
                limiteInferiorAux++;
            } else {
                vetorAuxiliar[contador] = vetor[meioAux];
                meioAux++;
            }
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            contador++;
        } while (limiteInferiorAux < meio && meioAux < limiteSuperior);

        for (int aux = limiteInferiorAux; aux < meio; aux++) {
            vetorAuxiliar[contador] = vetor[limiteInferiorAux];
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            limiteInferiorAux++;
            contador++;
        }

        for (int aux = meioAux; meioAux < limiteSuperior; aux++) {
            vetorAuxiliar[contador] = vetor[meioAux];
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            meioAux++;
            contador++;
        }

        contador = limiteInferior;
        while (contador < limiteSuperior) {
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            vetor[contador] = vetorAuxiliar[contador - limiteInferior];
            contador++;
        }
    }
}
