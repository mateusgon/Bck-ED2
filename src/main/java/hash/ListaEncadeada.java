package hash;

import model.Resultado;

public class ListaEncadeada { // Implementação da Lista Encadeada e a Inserção de valores para o Encadeamento Separado

    private NoListaEncadeada primeiro; // Possui um primeiro nó que se refere ao no de uma ListaEncadeada

    public ListaEncadeada() { // Sempre inicializado com null
        primeiro = null;
    }

    public ListaEncadeada(NoListaEncadeada primeiro) { // Construtor para colocar o primeiro
        this.primeiro = primeiro;
    }

    public void InserirListaEncadeada(Integer deputy_id, Resultado resultado) { // Função para inserir um valor na lista encadeada
        if (primeiro == null) { // Se ele estiver vazio, cria um NoListaEncadeada e insere na primeira posição da Lista
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            NoListaEncadeada no = new NoListaEncadeada(deputy_id, null); // O próximo será null
            primeiro = no;
        } else { // Se não estiver vazia a primeira posição, percorre a lista até achar a próxima posição vazia e criar o novo nó para isso.
            NoListaEncadeada aux = primeiro; 
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            NoListaEncadeada no = new NoListaEncadeada(deputy_id, null);
            aux.setProximo(no);
        }
    }

    public NoListaEncadeada getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaEncadeada primeiro) {
        this.primeiro = primeiro;
    }
    
    
}
