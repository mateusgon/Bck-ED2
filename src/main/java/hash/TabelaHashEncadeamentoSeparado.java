package hash;

import model.Resultado;

public class TabelaHashEncadeamentoSeparado {

    /**
     * *
     * A sua explicação de funcionamento estará no relatório. É composta por um
     * array de Listas Encadeadas. Possui também um tamanho como atributo
     * O tamanho é o mesmo da quantidade de dados lido informado no Entrada.txt.
     * Utiliza como função hashing a multiplicação
     */
    ListaEncadeadaCenario4 gastos[];
    Integer tamanho;

    public TabelaHashEncadeamentoSeparado(Integer tamanho) {
        gastos = new ListaEncadeadaCenario4[tamanho];
        this.tamanho = tamanho;
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = new ListaEncadeadaCenario4();
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

    public void EncadeamentoSeparado(Integer idDeputado[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < idDeputado.length; i++) {
            Integer indice = funcaoHash(idDeputado[i], resultado); // Descobre o valor do indice a ser inserido
            gastos[indice].InserirListaEncadeada(idDeputado[i], resultado); // Insere na Tabela Hash o id do deputado
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }
}
