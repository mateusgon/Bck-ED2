package hash;

import model.Resultado;

public class TabelaHashEncadeamentoSeparado {

    ListaEncadeada gastos[];
    Integer tamanho;

    public TabelaHashEncadeamentoSeparado(Integer tamanho) {
        gastos = new ListaEncadeada[tamanho];
        this.tamanho = tamanho;
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = new ListaEncadeada();
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

    public void EncadeamentoSeparado(Integer valor[], Resultado resultado) {
        Runtime runtime = Runtime.getRuntime();
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < valor.length; i++) {
            Integer indice = funcaoHash(valor[i], resultado);
            gastos[indice].InserirListaEncadeada(valor[i], resultado);
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }
}
