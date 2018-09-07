package ordenacao;

public class InsertionSort {
    public Long ordena (Integer vetor[])
    {
        long tempoInicial = System.currentTimeMillis();
        for (int i = 1; i < vetor.length; i++)
        {
            Integer aux = vetor[i];
            int j = i;
            while((j>0) && (vetor[j-1] > aux))
            {
                vetor[j] = vetor[j-1];
                j--;
            }
            vetor[j] = aux;
        }
        return System.currentTimeMillis() - tempoInicial;
    }
}
