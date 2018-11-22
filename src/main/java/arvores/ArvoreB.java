package arvores;

import model.Gasto;
import model.Resultado;

public class ArvoreB implements Cloneable {

    private Resultado resultado;
    private PaginaArvoreB raiz;
    private Integer m, mm;

    public ArvoreB() {
    }

    public ArvoreB(Integer m) {
        this.raiz = null;
        this.m = m;
        this.mm = 2 * m;
    }

    public void buscaAux(Gasto vetor[], Resultado resultado) {
        this.resultado = resultado;
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < vetor.length; i++) {
            pesquisa(vetor[i]);
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public Gasto pesquisa(Gasto reg) {
        return this.pesquisa(reg, this.raiz);
    }

    private Gasto pesquisa(Gasto reg, PaginaArvoreB ap) {
        if (ap == null) {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            return null;
        } else {
            Integer i = 0;
            while ((i < ap.getN() - 1) && reg.getIdGasto() > ap.getR()[i].getIdGasto()) {
                i++;
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (reg.getIdGasto().equals(ap.getR()[i].getIdGasto())) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                return ap.getR()[i];
            } else if (reg.getIdGasto() < ap.getR()[i].getIdGasto()) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                return pesquisa(reg, ap.getP()[i]);
            } else {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                return pesquisa(reg, ap.getP()[i + 1]);
            }
        }
    }

    public void insereAux(Gasto vetor[], Resultado resultado) {
        this.resultado = resultado;
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < vetor.length; i++) {
            insere(vetor[i]);
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public void insere(Gasto reg) {
        Gasto regRetorno[] = new Gasto[1];
        Boolean cresceu[] = new Boolean[1];

        PaginaArvoreB apRetorno = this.insere(reg, this.raiz, regRetorno, cresceu);
        if (cresceu[0]) {
            PaginaArvoreB apTemp = new PaginaArvoreB(this.mm);
            apTemp.getR()[0] = regRetorno[0];
            apTemp.getP()[0] = this.raiz;
            apTemp.getP()[1] = apRetorno;
            this.raiz = apTemp;
            resultado.setNumTrocas(resultado.getNumTrocas() + 4);
            this.raiz.setN(this.raiz.getN() + 1);
        } else {
            this.raiz = apRetorno;
        }
    }

    private PaginaArvoreB insere(Gasto reg, PaginaArvoreB ap, Gasto[] regRetorno, Boolean cresceu[]) {
        PaginaArvoreB apRetorno = null;
        if (ap == null) {
            cresceu[0] = true;
            regRetorno[0] = reg;
        } else {
            Integer i = 0;
            while ((i < ap.getN() - 1) && reg.getIdGasto() > ap.getR()[i].getIdGasto()) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                i++;
            }
            if (reg.getIdGasto().equals(ap.getR()[i].getIdGasto())) {
                cresceu[0] = false;
            } else {
                if (reg.getIdGasto() > ap.getR()[i].getIdGasto()) {
                    i++;
                }
                apRetorno = insere(reg, ap.getP()[i], regRetorno, cresceu);
                if (cresceu[0]) {
                    if (ap.getN() < this.mm) {
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                        this.insereNaPagina(ap, regRetorno[0], apRetorno);
                        cresceu[0] = false;
                        apRetorno = ap;
                    } else {
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                        PaginaArvoreB apTemp = new PaginaArvoreB(this.mm);
                        apTemp.getP()[0] = null;
                        if (i <= this.m) {
                            this.insereNaPagina(apTemp, ap.getR()[this.mm - 1], ap.getP()[this.mm]);
                            ap.setN(ap.getN() - 1);
                            this.insereNaPagina(ap, regRetorno[0], apRetorno);
                        } else {
                            this.insereNaPagina(apTemp, regRetorno[0], apRetorno);
                        }
                        for (Integer j = this.m + 1; j < this.mm; j++) {
                            this.insereNaPagina(apTemp, ap.getR()[j], ap.getP()[j + 1]);
                            ap.getP()[j + 1] = null;
                            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                        }
                        ap.setN(this.m);
                        apTemp.getP()[0] = ap.getP()[this.m + 1];
                        regRetorno[0] = ap.getR()[this.m];
                        apRetorno = apTemp;
                        resultado.setNumTrocas(resultado.getNumTrocas() + 3);
                    }
                }
            }
        }
        return (cresceu[0] ? apRetorno : ap);
    }

    private void insereNaPagina(PaginaArvoreB ap, Gasto reg, PaginaArvoreB apDir) {
        Integer k = ap.getN() - 1;
        while ((k >= 0) && (reg.getIdGasto() < ap.getR()[k].getIdGasto())) {
            ap.getR()[k + 1] = reg;
            ap.getP()[k + 2] = apDir;
            k--;
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            resultado.setNumTrocas(resultado.getNumTrocas() + 2);
        }
        ap.getR()[k + 1] = reg;
        ap.getP()[k + 2] = apDir;
        resultado.setNumTrocas(resultado.getNumTrocas() + 2);
        ap.setN(ap.getN() + 1);
    }

    public void excluirAux(Gasto vetor[], Resultado resultado) {
        this.resultado = resultado;
        long tempoInicial = System.nanoTime();
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(i);
            retira(vetor[i]);
        }
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public void retira(Gasto reg) {
        Boolean diminuiu[] = new Boolean[1];
        this.raiz = this.retira(reg, this.raiz, diminuiu);
        if (diminuiu[0] && (this.raiz.getN().equals(0))) {
            this.raiz = this.raiz.getP()[0];
        }
    }

    private PaginaArvoreB retira(Gasto reg, PaginaArvoreB ap, Boolean[] diminuiu) {
        if (ap == null) {
            diminuiu[0] = false;
        } else {
            Integer ind = 0;
            while ((ind < ap.getN() - 1) && reg.getIdGasto() > ap.getR()[ind].getIdGasto()) {
                ind++;
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (reg.getIdGasto().equals(ap.getR()[ind].getIdGasto())) {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                if (ap.getP()[ind] == null) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    ap.setN(ap.getN() - 1);
                    if (ap.getN() < this.m) {
                        diminuiu[0] = true;
                    } else {
                        diminuiu[0] = false;
                    }
                    for (Integer j = ind; j < ap.getN(); j++) {
                        ap.getR()[j] = ap.getR()[j + 1];
                        ap.getP()[j] = ap.getP()[j + 1];
                        resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                    }
                    ap.getP()[ap.getN()] = ap.getP()[ap.getN() + 1];
                    ap.getP()[ap.getN() + 1] = null;
                    resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                } else {
                    diminuiu[0] = antecessor(ap, ind, ap.getP()[ind]);
                    if (diminuiu[0]) {
                        diminuiu[0] = reconstitui(ap.getP()[ind], ap, ind);
                    }
                }
            } else {
                if (reg.getIdGasto() > ap.getR()[ind].getIdGasto()) {
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    ind++;
                }
                ap.getP()[ind] = retira(reg, ap.getP()[ind], diminuiu);
                if (diminuiu[0]) {
                    diminuiu[0] = reconstitui(ap.getP()[ind], ap, ind);
                }
            }
        }
        return ap;
    }

    private Boolean antecessor(PaginaArvoreB ap, Integer ind, PaginaArvoreB apPai) {
        Boolean diminuiu = true;
        if (apPai.getP()[apPai.getN()] != null) {
            diminuiu = antecessor(ap, ind, apPai.getP()[apPai.getN()]);
            if (diminuiu) {
                diminuiu = reconstitui(apPai.getP()[apPai.getN()], apPai, apPai.getN());
            }
        } else {
            apPai.setN(apPai.getN() - 1);
            ap.getR()[ind] = apPai.getR()[apPai.getN()];
            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            if (apPai.getN() < this.m) {
                diminuiu = true;
            } else {
                diminuiu = false;
            }
        }
        return diminuiu;
    }

    private Boolean reconstitui(PaginaArvoreB apPag, PaginaArvoreB apPai, Integer posPai) {
        Boolean diminuiu = true;
        if (posPai < apPai.getN()) {
            PaginaArvoreB aux = apPai.getP()[posPai + 1];
            Integer dispAux = (aux.getN() - this.m + 1) / 2;
            apPag.getR()[apPag.getN()] = apPai.getR()[posPai];
            apPag.setN(apPag.getN() + 1);
            apPag.getP()[apPag.getN()] = aux.getP()[0];
            aux.getP()[0] = null;
            resultado.setNumTrocas(resultado.getNumTrocas() + 3);
            if (dispAux > 0) {
                for (Integer j = 0; j < dispAux - 1; j++) {
                    this.insereNaPagina(apPag, aux.getR()[j], aux.getP()[j + 1]);
                    aux.getP()[j + 1] = null;
                }
                apPai.getR()[posPai] = aux.getR()[dispAux - 1];
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                aux.setN(aux.getN() - dispAux);
                for (Integer j = 0; j < aux.getN(); j++) {
                    aux.getR()[j] = aux.getR()[j + dispAux];
                    resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                }
                for (Integer j = 0; j <= aux.getN(); j++) {
                    aux.getP()[j] = aux.getP()[j + dispAux];
                    resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                }
                aux.getP()[aux.getN() + dispAux] = null;
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                diminuiu = false;
            } else {
                for (Integer j = 0; j < this.m; j++) {
                    this.insereNaPagina(apPag, aux.getR()[j], aux.getP()[j + 1]);
                    aux.getP()[j + 1] = null;
                    resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                }
                aux = apPai.getP()[posPai + 1];
                apPai.getP()[posPai + 1] = null;
                for (Integer j = posPai; j < apPai.getN() - 1; j++) {
                    apPai.getR()[j] = apPai.getR()[j + 1];
                    apPai.getP()[j + 1] = apPai.getP()[j + 2];
                    resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                }
                apPai.getP()[apPai.getN()] = null;
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                apPai.setN(apPai.getN() - 1);
                if (apPai.getN() < this.m) {
                    diminuiu = true;
                } else {
                    diminuiu = false;
                }
            }
        } else {
            PaginaArvoreB aux = apPai.getP()[posPai - 1];
            Integer dispAux = (aux.getN() - this.m + 1) / 2;
            for (Integer j = apPag.getN() - 1; j >= 0; j--) {
                apPag.getR()[j + 1] = apPag.getR()[j];
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            }
            apPag.getR()[0] = apPai.getR()[posPai - 1];
            for (Integer j = apPag.getN(); j >= 0; j--) {
                apPag.getP()[j + 1] = apPag.getP()[j];
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
            }
            apPag.setN(apPag.getN() + 1);
            if (dispAux > 0) {
                for (Integer j = 0; j < dispAux - 1; j++) {
                    this.insereNaPagina(apPag, aux.getR()[aux.getN() - j - 1], aux.getP()[aux.getN() - j]);
                    aux.getP()[aux.getN() - j] = null;
                    resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                }
                apPag.getP()[0] = aux.getP()[aux.getN() - dispAux + 1];
                aux.getP()[aux.getN() - dispAux + 1] = null;
                apPai.getR()[posPai - 1] = aux.getR()[aux.getN() - dispAux];
                aux.setN(aux.getN() - dispAux);
                resultado.setNumTrocas(resultado.getNumTrocas() + 3);
                diminuiu = false;
            } else {
                for (Integer j = 0; j < this.m; j++) {
                    this.insereNaPagina(aux, apPag.getR()[j], apPag.getP()[j + 1]);
                    apPag.getP()[j + 1] = null;
                }
                apPag = null;
                apPai.getP()[apPai.getN()] = null;
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                apPai.setN(apPai.getN() - 1);
                if (apPai.getN() < this.mm) {
                    diminuiu = true;
                } else {
                    diminuiu = false;
                }
            }
        }
        return diminuiu;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public ArvoreB clone() throws CloneNotSupportedException {
        return (ArvoreB) super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
