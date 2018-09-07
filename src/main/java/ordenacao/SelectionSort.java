package ordenacao;

public class SelectionSort {

    public long ordena(int vetor[], int tam) {
        long tempoInicial = System.currentTimeMillis();
        for (int indice = 0; indice < tam; ++indice) {
            int indiceMenor = indice;
            for (int indiceSeguinte = indice + 1; indiceSeguinte < tam; ++indiceSeguinte) {
                if (vetor[indiceSeguinte] < vetor[indiceMenor]) {
                    indiceMenor = indiceSeguinte;
                }
            }
            int aux = vetor[indice];
            vetor[indice] = vetor[indiceMenor];
            vetor[indiceMenor] = aux;
        }
        return System.currentTimeMillis() - tempoInicial;
    }
}
