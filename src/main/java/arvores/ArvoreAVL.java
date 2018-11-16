package arvores;

public class ArvoreAVL {

    private NoArvoreBinariaAVL raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public NoArvoreBinariaAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinariaAVL raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinariaAVL inserir(Integer chave, NoArvoreBinariaAVL no) {

        if (no == null) {
            NoArvoreBinariaAVL noNovo = new NoArvoreBinariaAVL(chave);
            return noNovo;
        } else {

            if (chave < no.getIdGasto()) {
                NoArvoreBinariaAVL noAux = inserir(chave, no.getFilhoEsquerda());
                no.setFilhoEsquerda(noAux);
            } else if (chave > no.getIdGasto()) {
                NoArvoreBinariaAVL noAux = inserir(chave, no.getFilhoDireita());
                no.setFilhoDireita(noAux);
            }

            Integer altura1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
            Integer altura2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
            Integer maiorValor = maiorValorEntreDoisNos(altura1, altura2);

            no.setAltura((1 + maiorValor));

            return verificaRotacao(no, chave);

        }
    }

    public NoArvoreBinariaAVL verificaRotacao(NoArvoreBinariaAVL no, Integer chave) {

        Integer fatorBalanceamento = fatorBalanceamento(no);

        if (fatorBalanceamento > 1 && no.getFilhoEsquerda().getIdGasto() > chave) {
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && no.getFilhoDireita().getIdGasto() < chave) {
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento > 1 && no.getFilhoEsquerda().getIdGasto() < chave) {
            NoArvoreBinariaAVL noAux = no.getFilhoEsquerda();
            no.setFilhoEsquerda(rotacaoEsquerda(noAux));
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -1 && no.getFilhoDireita().getIdGasto() > chave) {
            NoArvoreBinariaAVL noAux = no.getFilhoDireita();
            no.setFilhoDireita(rotacaoDireita(noAux));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public NoArvoreBinariaAVL rotacaoDireita(NoArvoreBinariaAVL no) {

        NoArvoreBinariaAVL noAux = no.getFilhoEsquerda();

        no.setFilhoEsquerda(noAux.getFilhoDireita());
        noAux.setFilhoDireita(no);

        Integer alturaSubArvore1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
        Integer alturaSubArvore2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
        no.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        alturaSubArvore1 = alturaDaSubArvoreDoNo(noAux.getFilhoEsquerda());
        alturaSubArvore2 = alturaDaSubArvoreDoNo(noAux.getFilhoDireita());
        noAux.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        return noAux;
    }

    public NoArvoreBinariaAVL rotacaoEsquerda(NoArvoreBinariaAVL no) {

        NoArvoreBinariaAVL noAux = no.getFilhoDireita();

        no.setFilhoDireita(noAux.getFilhoEsquerda());
        noAux.setFilhoEsquerda(no);

        Integer alturaSubArvore1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
        Integer alturaSubArvore2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
        no.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        alturaSubArvore1 = alturaDaSubArvoreDoNo(noAux.getFilhoEsquerda());
        alturaSubArvore2 = alturaDaSubArvoreDoNo(noAux.getFilhoDireita());
        noAux.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));
        return noAux;
    }

    public Integer fatorBalanceamento(NoArvoreBinariaAVL no) {
        if (no != null) {
            Integer alturaSubArvore1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
            Integer alturaSubArvore2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
            return alturaSubArvore1 - alturaSubArvore2;
        } else {
            return 0;
        }
    }

    public Integer alturaDaSubArvoreDoNo(NoArvoreBinariaAVL no) {
        if (no != null) {
            return no.getAltura();
        } else {
            return 0;
        }
    }

    public Integer maiorValorEntreDoisNos(Integer valor1, Integer valor2) {
        if (valor1 > valor2) {
            return valor1;
        } else {
            return valor2;
        }
    }

    public Integer buscar(Integer idGasto, NoArvoreBinariaAVL no) {
        if (no == null) {
            return null;
        } else {
            if (idGasto < no.getIdGasto()) {
                return buscar(idGasto, no.getFilhoEsquerda());
            } else if (idGasto > no.getIdGasto()) {
                return buscar(idGasto, no.getFilhoDireita());
            } else {
                return idGasto;
            }
        }
    }

    public NoArvoreBinariaAVL excluirNo(Integer valor, NoArvoreBinariaAVL no) {
        if (no == null) {
            return no;
        } else {
            if (no.getIdGasto() > valor) {
                NoArvoreBinariaAVL noAux = excluirNo(valor, no.getFilhoEsquerda());
                no.setFilhoEsquerda(noAux);
            } else if (no.getIdGasto() < valor) {
                NoArvoreBinariaAVL noAux = excluirNo(valor, no.getFilhoDireita());
                no.setFilhoDireita(noAux);
            } else {
                if (no.getFilhoEsquerda() == null || no.getFilhoDireita() == null) {
                    NoArvoreBinariaAVL noAux = null;
                    if (no.getFilhoEsquerda() == null) {
                        noAux = no.getFilhoDireita();
                    } else {
                        noAux = no.getFilhoEsquerda();
                    }

                    if (noAux == null) {
                        noAux = no;
                        no = null;
                    } else {
                        no = noAux;
                    }
                } else {
                    NoArvoreBinariaAVL noAux = noDeMenorValor(no.getFilhoDireita());
                    no.setIdGasto(noAux.getIdGasto());
                    no.setFilhoDireita(excluirNo(no.getIdGasto(), no.getFilhoDireita()));
                }
            }

            if (no == null) {
                return no;
            }

            Integer altura1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
            Integer altura2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
            Integer maiorValor = maiorValorEntreDoisNos(altura1, altura2);

            no.setAltura((1 + maiorValor));

            Integer fatorDeBalanceamento = fatorBalanceamento(no);

            if (fatorDeBalanceamento > 1 && fatorBalanceamento(no.getFilhoEsquerda()) >= 0) {
                return rotacaoDireita(no);
            }

            if (fatorDeBalanceamento > 1 && fatorBalanceamento(no.getFilhoEsquerda()) < 0) {
                no.setFilhoEsquerda(rotacaoEsquerda(no.getFilhoEsquerda()));
                return rotacaoDireita(no);
            }

            if (fatorDeBalanceamento < -1 && fatorBalanceamento(no.getFilhoDireita()) <= 0) {
                return rotacaoEsquerda(no);
            }

            if (fatorDeBalanceamento < -1 && fatorBalanceamento(no.getFilhoDireita()) > 0) {
                no.setFilhoDireita(rotacaoDireita(no.getFilhoDireita()));
                return rotacaoEsquerda(no);
            }
            return no;
        }
    }

    private NoArvoreBinariaAVL noDeMenorValor(NoArvoreBinariaAVL no) {
        NoArvoreBinariaAVL noAtual = no;

        while (noAtual.getFilhoEsquerda()!= null) {
            noAtual = noAtual.getFilhoEsquerda();
        }

        return noAtual;
    }


}