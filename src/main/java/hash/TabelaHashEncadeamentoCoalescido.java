package hash;

import model.Resultado;

public class TabelaHashEncadeamentoCoalescido {

    NoListaEncadeamentoCoalescido gastos[];
    Integer tamanho;
    Integer ultimaPosicaoVazia;

    public TabelaHashEncadeamentoCoalescido(Integer tamanho) {
        gastos = new NoListaEncadeamentoCoalescido[tamanho];
        this.tamanho = tamanho;
        this.ultimaPosicaoVazia = tamanho;
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
        Integer auxUltimaPosicaoVazia = tamanho - 1;
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = funcaoHash(valor[i], resultado);
            if (gastos[posicao].getDeputy_id() == -1) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                gastos[posicao].setDeputy_id(valor[i]);
            } else {
                Boolean trocado = false;
                Integer contador = ultimaPosicaoVazia;
                while (contador > 0 && !trocado) {
                    contador--;
                    if (gastos[contador].getDeputy_id() == -1) {
                        gastos[contador].setDeputy_id(valor[i]);
                        if (gastos[posicao].getProximaPosicaoVetor() == -1) {
                            gastos[posicao].setProximaPosicaoVetor(contador);
                        } else {
                            gastos[auxUltimaPosicaoVazia].setProximaPosicaoVetor(contador);
                        }
                        auxUltimaPosicaoVazia = contador;
                        ultimaPosicaoVazia = contador;
                        trocado = true;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }
            }
        }
        for (int i = 0; i < tamanho && tamanho == 1000; i++) {
            System.out.println(i + "-" + gastos[i].getDeputy_id());
            System.out.println("Aponta para" + gastos[i].getProximaPosicaoVetor());
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }

}
