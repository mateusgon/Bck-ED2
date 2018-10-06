package hash;

import java.util.Objects;
import model.Gasto;

public class ListaEncadeadaPartidoItem2 { // Possui as mesmas características do ListaEncadeadaCenario4, contudo, é uma lista Encadeada de NoListaEncadeadaPartidoItem2, por isso, outra classe.

    private NoListaEncadeadaPartidoItem2 primeiro;

    public ListaEncadeadaPartidoItem2() {
        primeiro = null;
    }

    public ListaEncadeadaPartidoItem2(NoListaEncadeadaPartidoItem2 primeiro) {
        this.primeiro = primeiro;
    }

    public Integer inserirListaEncadeada(Gasto gasto) {

        if (primeiro == null) { // Se a lista estiver vazia, insere nesse if.
            NoListaEncadeadaPartidoItem2 no = new NoListaEncadeadaPartidoItem2(gasto.getPolitical_party(), gasto.getReceipt_value(), null);
            primeiro = no;
            return 1;
        } else { // Se ela não estiver vazia, verifica se já está na lista. Se sim, acrescenta o valor, se não, cria um nó novo.
            NoListaEncadeadaPartidoItem2 aux = primeiro;
            while (!Objects.equals(aux.getProximo(), null)) {
                if (Objects.equals(aux.getNome(), gasto.getPolitical_party())) {
                    aux.setValor(aux.getValor() + gasto.getReceipt_value());
                    return 0;
                }
                aux = aux.getProximo();
            }
            if (Objects.equals(aux.getNome(), gasto.getPolitical_party())) {
                aux.setValor(aux.getValor() + gasto.getReceipt_value());
                return 0;
            }
            if (aux.getProximo() == null) {
                NoListaEncadeadaPartidoItem2 no = new NoListaEncadeadaPartidoItem2(gasto.getPolitical_party(), gasto.getReceipt_value(), null);
                aux.setProximo(no);
                return 1;
            }
        }
        return -1;
    }

    public NoListaEncadeadaPartidoItem2 getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaEncadeadaPartidoItem2 primeiro) {
        this.primeiro = primeiro;
    }

}
