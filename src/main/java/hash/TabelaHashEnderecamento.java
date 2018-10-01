package hash;

public class TabelaHashEnderecamento {

    Integer gastos[] = new Integer[750000];
    Integer tamanho = 750000;

    public TabelaHashEnderecamento() {
        for (int i = 0; i < gastos.length; i++) {
            gastos[i] = -1;
        }
    }

    public double funcaoHash(Integer valor) {
        return valor % 0.61803399;
    }

    public double funcaoHash2(Integer valor) {
        return valor % 0.59357;
    }

    public void insereSondagemLinear(Integer valor[]) {
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = (int) funcaoHash(valor[i]);
            if (posicao >= gastos.length) {
                posicao = posicao - gastos.length;
            }
            if (gastos[posicao] == -1) {
                gastos[posicao] = valor[i];
            } else {
                Integer repeticao = 1;
                Boolean naoInserido = true;
                while (naoInserido) {
                    Integer indice = SondagemLinear(posicao, valor[i], repeticao);
                    if (gastos[indice] == -1) {
                        gastos[indice] = valor[i];
                        naoInserido = false;
                    } else {
                        repeticao++;
                    }
                }
            }
        }
    }

    public Integer SondagemLinear(Integer posicao, Integer valor, Integer repeticao) {
        Integer indice = posicao + repeticao;
        if (posicao >= (gastos.length)) {
            return 0;
        }
        return indice;
    }

    public void insereSondagemQuadratica(Integer valor[]) {
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = (int) funcaoHash(valor[i]);
            if (posicao >= gastos.length) {
                posicao = posicao - gastos.length;
            }
            if (gastos[posicao] == -1) {
                gastos[posicao] = valor[i];
            } else {
                Integer repeticao = 1;
                Boolean naoInserido = true;
                while (naoInserido) {
                    Integer indice = SondagemQuadratica(posicao, valor[i], repeticao);
                    if (gastos[indice] == -1) {
                        gastos[indice] = valor[i];
                        naoInserido = false;
                    } else {
                        repeticao++;
                    }
                }
            }
        }
    }

    public Integer SondagemQuadratica(Integer posicao, Integer valor, Integer quantidadeColisao) {
        Integer indice = posicao + 1 * quantidadeColisao + 2 * (int) Math.pow(quantidadeColisao, 2);
        if (indice >= (gastos.length) || indice <= 0) {
            return 0;
        }
        return indice;

    }

    public void insereDuploHash(Integer valor[]) {
        for (int i = 0; i < valor.length; i++) {
            Integer posicao = (int) funcaoHash(valor[i]);
            if (posicao >= gastos.length) {
                posicao = posicao - gastos.length;
            }
            if (gastos[posicao] == -1) {
                gastos[posicao] = valor[i];
            } else {
                Integer posicao2 = (int) funcaoHash2(valor[i]);
                Integer repeticao = 1;
                Boolean naoInserido = true;
                while (naoInserido) {
                    Integer indice = DuploHash(posicao, posicao2, valor[i], repeticao);
                    if (gastos[indice] == -1) {
                        gastos[indice] = valor[i];
                        naoInserido = false;
                    } else {
                        repeticao++;
                    }
                }
            }
        }
    }

    public Integer DuploHash(Integer posicao, Integer posicao2, Integer valor, Integer quantidadeColisao) {
        Integer indice = posicao + 1 * quantidadeColisao + 2 * (int) Math.pow(quantidadeColisao, 2);
        if (indice >= (gastos.length) || indice <= 0) {
            return 0;
        }
        return indice;
    }
}
