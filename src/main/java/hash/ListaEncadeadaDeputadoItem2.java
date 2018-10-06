package hash;

import java.util.Objects;
import model.Gasto;

public class ListaEncadeadaDeputadoItem2 {

    private NoListaEncadeadaDeputadoItem2 primeiro;

    public ListaEncadeadaDeputadoItem2() {
        primeiro = null;
    }

    public ListaEncadeadaDeputadoItem2(NoListaEncadeadaDeputadoItem2 primeiro) {
        this.primeiro = primeiro;
    }

    public Integer inserirListaEncadeada(Gasto gasto) {

        if (primeiro == null) {
            NoListaEncadeadaDeputadoItem2 no = new NoListaEncadeadaDeputadoItem2(gasto.getDeputy_name(),gasto.getPolitical_party(), gasto.getDeputy_id(), gasto.getReceipt_value(), null);
            primeiro = no;
            return 1;
        } else {
            NoListaEncadeadaDeputadoItem2 aux = primeiro;
            while (!Objects.equals(aux.getProximo(), null)) {
                if (Objects.equals(aux.getDeputy_id(), gasto.getDeputy_id())) {
                    System.out.println("Entrei");
                    aux.setValor(aux.getValor() + gasto.getReceipt_value());
                    return 0;
                }
                aux = aux.getProximo();
            }
            if (Objects.equals(aux.getDeputy_id(), gasto.getDeputy_id())) {
                aux.setValor(aux.getValor() + gasto.getReceipt_value());
                return 0;
            }
            if (aux.getProximo() == null) {
                NoListaEncadeadaDeputadoItem2 no = new NoListaEncadeadaDeputadoItem2(gasto.getDeputy_name(),gasto.getPolitical_party(), gasto.getDeputy_id(), gasto.getReceipt_value(), null);
                aux.setProximo(no);
                return 1;
            }
        }
        return -1;
    }

    public NoListaEncadeadaDeputadoItem2 getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NoListaEncadeadaDeputadoItem2 primeiro) {
        this.primeiro = primeiro;
    }

}
