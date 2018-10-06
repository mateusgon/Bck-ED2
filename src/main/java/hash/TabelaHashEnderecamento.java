package hash;

import model.Resultado;

public class TabelaHashEnderecamento {

    /**
     * *
     * A explicação de funcionamento da sondagem linear, sondagem quadrática e do duplo hash estará no relatório.
     * É composta por um vetor de identificadores dos usuários nesse caso, chamado de gastos.
     * Possui também um tamanho já predefinido.
     * A função de hashing da sondagem linear, sondagem quadrática e duplo hash são a de multiplicação e divisão
     */
    
    Integer gastos[] = new Integer[1000000];
    Integer tamanho = 1000000;

    public TabelaHashEnderecamento() {
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = -1;
        }
    }

    public int funcaoHash(Integer valor, Resultado resultado) { // Função de multiplicação
        double indice = valor * 0.61803399;
        while (indice >= gastos.length) {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            indice = indice - gastos.length;
        }
        return (int) indice;
    }

    public double funcaoHash2(Integer valor) { // Função de divisão
        return valor % tamanho;
    }

    public void insereSondagemLinear(Integer valor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = funcaoHash(valor[i], resultado);
            if (gastos[posicao] == -1) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                gastos[posicao] = valor[i];
            } else {
                Integer repeticao = 1;
                Boolean naoInserido = true;
                while (naoInserido) {
                    Integer indice = SondagemLinear(posicao, repeticao);
                    if (indice == -1) {
                        break;
                    }
                    if (gastos[indice] == -1) {
                        gastos[indice] = valor[i];
                        naoInserido = false;
                    } else {
                        repeticao++;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }
            }
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }

    public Integer SondagemLinear(Integer posicao, Integer repeticao) {
        Integer indice = posicao + repeticao;
        if (posicao >= (gastos.length)) {
            return -1;
        }
        return indice;
    }

    public void insereSondagemQuadratica(Integer valor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = funcaoHash(valor[i], resultado);
            if (gastos[posicao] == -1) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                gastos[posicao] = valor[i];
            } else {
                Integer repeticao = 1;
                Boolean naoInserido = true;
                while (naoInserido) {
                    Integer indice = SondagemQuadratica(posicao, repeticao);
                    if (indice == -1) {
                        break;
                    }
                    if (gastos[indice] == -1) {
                        gastos[indice] = valor[i];
                        naoInserido = false;
                    } else {
                        repeticao++;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }
            }
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }

    public Integer SondagemQuadratica(Integer posicao, Integer quantidadeColisao) {
        Integer indice = (posicao + 2 * quantidadeColisao + 1 * (int) Math.pow(quantidadeColisao, 2)) % 999983;
        if (indice >= (gastos.length) || indice <= 0) {
            return -1;
        }
        return indice;

    }

    public void insereDuploHash(Integer valor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = funcaoHash(valor[i], resultado);
            if (gastos[posicao] == -1) {
                gastos[posicao] = valor[i];
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            } else {
                Integer posicao2 = (int) funcaoHash2(valor[i]);
                Integer repeticao = 1;
                Boolean naoInserido = true;
                while (naoInserido) {
                    Integer indice = DuploHash(posicao, posicao2, repeticao);
                    if (indice == -1) {
                        break;
                    }
                    if (gastos[indice] == -1) {
                        gastos[indice] = valor[i];
                        naoInserido = false;
                    } else {
                        repeticao++;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }
            }
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        resultado.setMemoriaGasto(memory);
    }

    public Integer DuploHash(Integer posicao, Integer posicao2, Integer quantidadeColisao) {
        Integer indice = (posicao + posicao2 * quantidadeColisao) % 999983;
        if (indice >= (gastos.length) || indice <= 0) {
            return -1;
        }
        return indice;
    }
}
