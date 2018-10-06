package hash;

import model.Resultado;

public class ListaEncadeadaCenario4 { // Implementação da Lista Encadeada e a Inserção de valores para o Encadeamento Separado

    private NoListaEncadeadaCenario4 primeiro; // Possui um primeiro nó que se refere ao no de uma ListaEncadeada
    private NoListaEncadeadaCenario4 atual;

    public ListaEncadeadaCenario4() { // Sempre inicializado com null
        primeiro = null;
        atual = null;
    }

    public ListaEncadeadaCenario4(NoListaEncadeadaCenario4 primeiro) { // Construtor para colocar o primeiro
        this.primeiro = primeiro;
    }

    public void InserirListaEncadeada(Integer deputy_id, Resultado resultado) { // Função para inserir um valor na lista encadeada
        if (primeiro == null) { // Se ele estiver vazio, cria um NoListaEncadeada e insere na primeira posição da Lista
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            NoListaEncadeadaCenario4 no = new NoListaEncadeadaCenario4(deputy_id, null); // O próximo será null
            primeiro = no;
            atual = no;
        } else { // Se não estiver vazia a primeira posição, percorre a lista até achar a próxima posição vazia e criar o novo nó para isso.
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            NoListaEncadeadaCenario4 aux = atual;
            NoListaEncadeadaCenario4 no = new NoListaEncadeadaCenario4(deputy_id, null);
            aux.setProximo(no);
            atual = no;
        }
    }

    public NoListaEncadeadaCenario4 getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaEncadeadaCenario4 primeiro) {
        this.primeiro = primeiro;
    }

}
