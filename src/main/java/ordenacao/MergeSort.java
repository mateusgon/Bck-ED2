package ordenacao;

import model.Gasto;

public class MergeSort {

    public Long ordenaInteiro (Integer vetor[])
    {
        long tempoInicial = System.currentTimeMillis();
        mergeSortInteiro(vetor, 0, vetor.length-1);
        return System.currentTimeMillis() - tempoInicial;
    }
    
    public void mergeSortInteiro (Integer vetor[], int inicio, int fim)
    {
        if (inicio < fim)
        {
            int meio = ((inicio+fim)/2);
            mergeSortInteiro(vetor, inicio, meio);
            mergeSortInteiro(vetor, meio+1, fim);
            merge(vetor, inicio, meio, fim);
        }
        else
        {
            return;
        }
    }
    
    public void merge (Integer vetor[], int inicio, int meio, int fim)
    {
        Integer auxiliar[] = new Integer[vetor.length]; 
        for (int i = inicio; i <= fim; i++)
        {
            auxiliar[i] = vetor[i];
        }
        
        int i = inicio;
        int j = meio+1;
        int k = inicio;
        
        while(i <= meio && j <= fim)
        {
            if (auxiliar[i] < auxiliar[j])
            {
                vetor[k] = auxiliar[i];
                i++;
            }
            else
            {
                vetor[k] = auxiliar[j];
                j++;
            }
            k++;
        }
        
        while (i <= meio)
        {
            vetor[k] = auxiliar[i];
            i++;
            k++;
        }
        
        while (j <= fim)
        {
            vetor[k] = auxiliar[j];
            j++;
            k++;
        }
    }
}
