package arvores;

import model.Gasto;
import model.Resultado;

public class MinhaArvore implements Cloneable {

    private Resultado resultado;
    private NoDaMinhaArvore raiz;

    public void insereGastos(Gasto vetor[], Resultado resultado) {
        this.resultado = resultado;
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < vetor.length; i++) {
            setRaiz(inserir(vetor[i].getIdGasto(), getRaiz()));
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public void buscaGastos(Gasto vetor[], Resultado resultado) {
        this.resultado = resultado;
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < vetor.length; i++) {
            buscar(vetor[i].getIdGasto(), getRaiz());
        }
        resultado.setTempoGasto((System.nanoTime() - tempoInicial));
    }

    public void excluirGastos(Gasto vetor[], Resultado resultado) {
        this.resultado = resultado;
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < vetor.length; i++) {
            setRaiz(excluirNo(vetor[i].getIdGasto(), getRaiz()));
        }
        resultado.setTempoGasto((System.nanoTime() - tempoInicial));
    }

    @Override
    public MinhaArvore clone() throws CloneNotSupportedException {
        return (MinhaArvore) super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public MinhaArvore() {
        raiz = null;
    }

    public NoDaMinhaArvore getRaiz() {
        return raiz;
    }

    public void setRaiz(NoDaMinhaArvore raiz) {
        this.raiz = raiz;
    }

    public NoDaMinhaArvore inserir(Integer chave, NoDaMinhaArvore no) {

        if (no == null) {
            NoDaMinhaArvore noNovo = new NoDaMinhaArvore(chave);
            return noNovo;
        } else {

            if (chave < no.getIdGasto()) {
                NoDaMinhaArvore noAux = inserir(chave, no.getFilhoEsquerda());
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                no.setFilhoEsquerda(noAux);
            } else if (chave > no.getIdGasto()) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                NoDaMinhaArvore noAux = inserir(chave, no.getFilhoDireita());
                no.setFilhoDireita(noAux);
            }
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);

            Integer altura1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
            Integer altura2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
            Integer maiorValor = maiorValorEntreDoisNos(altura1, altura2);

            no.setAltura((1 + maiorValor));

            return verificaRotacao(no, chave);

        }
    }

    public NoDaMinhaArvore verificaRotacao(NoDaMinhaArvore no, Integer chave) {

        Integer fatorBalanceamento = fatorBalanceamento(no);

        if (fatorBalanceamento > 2 && no.getFilhoEsquerda().getIdGasto() > chave) {
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -2 && no.getFilhoDireita().getIdGasto() < chave) {
            return rotacaoEsquerda(no);
        }

        if (fatorBalanceamento > 2 && no.getFilhoEsquerda().getIdGasto() < chave) {
            NoDaMinhaArvore noAux = no.getFilhoEsquerda();
            no.setFilhoEsquerda(rotacaoEsquerda(noAux));
            return rotacaoDireita(no);
        }

        if (fatorBalanceamento < -2 && no.getFilhoDireita().getIdGasto() > chave) {
            NoDaMinhaArvore noAux = no.getFilhoDireita();
            no.setFilhoDireita(rotacaoDireita(noAux));
            return rotacaoEsquerda(no);
        }

        resultado.setNumComparacoes(resultado.getNumComparacoes() + 4);

        return no;
    }

    public NoDaMinhaArvore rotacaoDireita(NoDaMinhaArvore no) {

        NoDaMinhaArvore noAux = no.getFilhoEsquerda();

        no.setFilhoEsquerda(noAux.getFilhoDireita());
        noAux.setFilhoDireita(no);

        Integer alturaSubArvore1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
        Integer alturaSubArvore2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
        no.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        alturaSubArvore1 = alturaDaSubArvoreDoNo(noAux.getFilhoEsquerda());
        alturaSubArvore2 = alturaDaSubArvoreDoNo(noAux.getFilhoDireita());
        noAux.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        resultado.setNumTrocas(resultado.getNumTrocas() + 2);

        return noAux;
    }

    public NoDaMinhaArvore rotacaoEsquerda(NoDaMinhaArvore no) {

        NoDaMinhaArvore noAux = no.getFilhoDireita();

        no.setFilhoDireita(noAux.getFilhoEsquerda());
        noAux.setFilhoEsquerda(no);

        Integer alturaSubArvore1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
        Integer alturaSubArvore2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
        no.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        alturaSubArvore1 = alturaDaSubArvoreDoNo(noAux.getFilhoEsquerda());
        alturaSubArvore2 = alturaDaSubArvoreDoNo(noAux.getFilhoDireita());
        noAux.setAltura((maiorValorEntreDoisNos(alturaSubArvore1, alturaSubArvore2) + 1));

        resultado.setNumTrocas(resultado.getNumTrocas() + 2);

        return noAux;
    }

    public Integer fatorBalanceamento(NoDaMinhaArvore no) {
        if (no != null) {
            Integer alturaSubArvore1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
            Integer alturaSubArvore2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
            return alturaSubArvore1 - alturaSubArvore2;
        } else {
            return 0;
        }
    }

    public Integer alturaDaSubArvoreDoNo(NoDaMinhaArvore no) {
        if (no != null) {
            return no.getAltura();
        } else {
            return 0;
        }
    }

    public Integer maiorValorEntreDoisNos(Integer valor1, Integer valor2) {
        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
        if (valor1 > valor2) {
            return valor1;
        } else {
            return valor2;
        }
    }

    public Integer buscar(Integer idGasto, NoDaMinhaArvore no) {
        if (no == null) {
            return null;
        } else {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            if (idGasto < no.getIdGasto()) {
                return buscar(idGasto, no.getFilhoEsquerda());
            } else if (idGasto > no.getIdGasto()) {
                return buscar(idGasto, no.getFilhoDireita());
            } else {
                return idGasto;
            }
        }
    }

    public NoDaMinhaArvore excluirNo(Integer valor, NoDaMinhaArvore no) {
        if (no == null) {
            return no;
        } else {
            if (no.getIdGasto() > valor) {
                NoDaMinhaArvore noAux = excluirNo(valor, no.getFilhoEsquerda());
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                no.setFilhoEsquerda(noAux);
            } else if (no.getIdGasto() < valor) {
                NoDaMinhaArvore noAux = excluirNo(valor, no.getFilhoDireita());
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                no.setFilhoDireita(noAux);
            } else {
                if (no.getFilhoEsquerda() == null || no.getFilhoDireita() == null) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    NoDaMinhaArvore noAux = null;
                    if (no.getFilhoEsquerda() == null) {
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                        noAux = no.getFilhoDireita();
                        resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                    } else {
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                        noAux = no.getFilhoEsquerda();
                        resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                    }
                    if (noAux == null) {
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                        noAux = no;
                        no = null;
                    } else {
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                        no = noAux;
                    }
                } else {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    NoDaMinhaArvore noAux = noDeMenorValor(no.getFilhoDireita());
                    no.setIdGasto(noAux.getIdGasto());
                    no.setFilhoDireita(excluirNo(no.getIdGasto(), no.getFilhoDireita()));
                    resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                }
            }
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);

            if (no == null) {
                return no;
            }
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);

            Integer altura1 = alturaDaSubArvoreDoNo(no.getFilhoEsquerda());
            Integer altura2 = alturaDaSubArvoreDoNo(no.getFilhoDireita());
            Integer maiorValor = maiorValorEntreDoisNos(altura1, altura2);

            no.setAltura((1 + maiorValor));

            Integer fatorDeBalanceamento = fatorBalanceamento(no);

            if (fatorDeBalanceamento > 2 && fatorBalanceamento(no.getFilhoEsquerda()) >= 0) {
                return rotacaoDireita(no);
            }

            if (fatorDeBalanceamento > 2 && fatorBalanceamento(no.getFilhoEsquerda()) < 0) {
                no.setFilhoEsquerda(rotacaoEsquerda(no.getFilhoEsquerda()));
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                return rotacaoDireita(no);
            }

            if (fatorDeBalanceamento < -2 && fatorBalanceamento(no.getFilhoDireita()) <= 0) {
                return rotacaoEsquerda(no);
            }

            if (fatorDeBalanceamento < -2 && fatorBalanceamento(no.getFilhoDireita()) > 0) {
                no.setFilhoDireita(rotacaoDireita(no.getFilhoDireita()));
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                return rotacaoEsquerda(no);
            }

            resultado.setNumComparacoes(resultado.getNumComparacoes() + 4);
            return no;
        }
    }

    private NoDaMinhaArvore noDeMenorValor(NoDaMinhaArvore no) {
        NoDaMinhaArvore noAtual = no;

        while (noAtual.getFilhoEsquerda() != null) {
            noAtual = noAtual.getFilhoEsquerda();
        }

        return noAtual;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

}

