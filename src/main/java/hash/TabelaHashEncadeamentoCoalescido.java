package hash;

import model.Resultado;

public class TabelaHashEncadeamentoCoalescido {

    NoListaEncadeamentoCoalescido gastos[] = new NoListaEncadeamentoCoalescido[1500000];
    Integer tamanho = 1500000;

    public TabelaHashEncadeamentoCoalescido() {
        for (int i = 0; i < tamanho; i++) {
            gastos[i] = new NoListaEncadeamentoCoalescido();
        }
    }

    public int funcaoHash(Integer valor, Resultado resultado) {
        double indice = valor * 0.61803399;
        while (indice >= gastos.length) {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            indice = indice - gastos.length;
        }
        return (int) indice;
    }

    public void encadeamentoCoalescido(Integer valor[], Resultado resultado) {
        Runtime runtime = Runtime.getRuntime();
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = funcaoHash(valor[i], resultado);
            if (gastos[i].getDeputy_id() == -1) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                gastos[i].setDeputy_id(valor[i]);
            } else {
                Boolean inserido = false;
                Integer indiceReferencia = posicao;
                Integer auxTamanho = tamanho;
                while (auxTamanho > 0 && !inserido) {
                    auxTamanho--;
                    if (gastos[auxTamanho].getDeputy_id() == -1) {
                        gastos[auxTamanho].setDeputy_id(valor[i]);
                        gastos[posicao].setProximaPosicaoVetor(indiceReferencia);
                        inserido = true;
                    } else {
                        indiceReferencia = auxTamanho;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }
            }
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }

}
