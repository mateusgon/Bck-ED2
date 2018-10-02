package model;

public class ListaEncadeada {

    NoListaEncadeada primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public ListaEncadeada(NoListaEncadeada primeiro) {
        this.primeiro = primeiro;
    }

    public void InserirListaEncadeada(Integer deputy_id, Resultado resultado) {
        if (primeiro == null) {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            NoListaEncadeada no = new NoListaEncadeada(deputy_id, null);
            primeiro = no;
        } else {
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
}
