package hash;

import model.ListaEncadeada;
import model.Resultado;

public class TabelaHashEncadeamento {

    ListaEncadeada gastos[] = new ListaEncadeada[50000];
    Integer tamanho = 50000;

    public TabelaHashEncadeamento() {
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = new ListaEncadeada();
        }
    }

    public double funcaoHash(Integer valor) {
        return valor * 0.61803399;
    }

    public void EncadeamentoSeparado(Integer valor[], Resultado resultado) {
        for (int i = 0; i < valor.length; i++) {
            Integer indice = (int) funcaoHash(valor[i]);
            if (indice >= gastos.length) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                indice = indice - gastos.length;
            }
            gastos[indice].InserirListaEncadeada(valor[i], resultado);
        }
    }
}
