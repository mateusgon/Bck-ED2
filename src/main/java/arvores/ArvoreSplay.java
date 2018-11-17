package arvores;

import java.util.Objects;

public class ArvoreSplay {

    private NoArvoreBinariaSplay raiz;

    public ArvoreSplay() {
        this.raiz = null;
    }

    public NoArvoreBinariaSplay puxarParaRaiz(NoArvoreBinariaSplay no, Integer idGasto) {
        if (no == null) {
            return null;
        }

        if (idGasto < no.getIdGasto()) {
            if (no.getFilhoEsquerda() == null) {
                return no;
            }

            if (idGasto < no.getFilhoEsquerda().getIdGasto()) {
                no.getFilhoEsquerda().setFilhoEsquerda(puxarParaRaiz(no.getFilhoEsquerda().getFilhoEsquerda(), idGasto));
                no = rotacaoDireita(no);
            } else if (idGasto > no.getFilhoEsquerda().getIdGasto()) {
                no.getFilhoEsquerda().setFilhoDireita(puxarParaRaiz(no.getFilhoEsquerda().getFilhoDireita(), idGasto));
                if (no.getFilhoEsquerda().getFilhoDireita() != null) {
                    no.setFilhoEsquerda(rotacaoEsquerda(no.getFilhoEsquerda()));
                }
            }

            if (no.getFilhoEsquerda() == null) {
                return no;
            } else {
                return rotacaoDireita(no);
            }
        } else if (idGasto > no.getIdGasto()) {
            if (no.getFilhoDireita() == null) {
                return no;
            }

            if (idGasto < no.getFilhoDireita().getIdGasto()) {
                no.getFilhoDireita().setFilhoEsquerda(puxarParaRaiz(no.getFilhoDireita().getFilhoEsquerda(), idGasto));
                if (no.getFilhoDireita().getFilhoEsquerda() != null) {
                    no.setFilhoDireita(rotacaoDireita(no.getFilhoDireita()));
                }
            } else if (idGasto > no.getFilhoDireita().getIdGasto()) {
                no.getFilhoDireita().setFilhoDireita(puxarParaRaiz(no.getFilhoDireita().getFilhoDireita(), idGasto));
                no = rotacaoEsquerda(no);
            }

            if (no.getFilhoDireita() == null) {
                return no;
            } else {
                return rotacaoEsquerda(no);
            }
        } else {
            return no;
        }
    }

    public void inserirSplay(Integer idGasto) {
        if (raiz == null) {
            NoArvoreBinariaSplay no = new NoArvoreBinariaSplay(idGasto);
            raiz = no;
            return;
        }

        NoArvoreBinariaSplay noAux = puxarParaRaiz(raiz, idGasto);
        raiz = noAux;

        if (idGasto < raiz.getIdGasto()) {
            NoArvoreBinariaSplay noAux2 = new NoArvoreBinariaSplay(idGasto);
            noAux2.setFilhoDireita(raiz);
            noAux2.setFilhoEsquerda(raiz.getFilhoEsquerda());
            raiz.setFilhoEsquerda(null);
            raiz = noAux2;
        } else if (idGasto > raiz.getIdGasto()) {
            NoArvoreBinariaSplay noAux2 = new NoArvoreBinariaSplay(idGasto);
            noAux2.setFilhoEsquerda(raiz);
            noAux2.setFilhoDireita(raiz.getFilhoDireita());
            raiz.setFilhoDireita(null);
            raiz = noAux2;
        } else {
            raiz.setIdGasto(idGasto);
        }

    }

    public void removerDaArvore(Integer idGasto) {
        if (raiz == null) {
            return;
        }

        raiz = puxarParaRaiz(raiz, idGasto);

        if (Objects.equals(idGasto, raiz.getIdGasto())) {
            if (raiz.getFilhoEsquerda() == null) {
                raiz = raiz.getFilhoDireita();
            } else {
                NoArvoreBinariaSplay noAux = raiz.getFilhoDireita();
                raiz = raiz.getFilhoEsquerda();
                puxarParaRaiz(noAux, idGasto);
                raiz.setFilhoDireita(noAux);
            }
        }
    }

    public Boolean procurar(Integer idGasto) {
        raiz = puxarParaRaiz(raiz, idGasto);
        if (Objects.equals(idGasto, raiz.getIdGasto())) {
            return true;
        } else {
            return false;
        }
    }

    public NoArvoreBinariaSplay rotacaoDireita(NoArvoreBinariaSplay no) {
        NoArvoreBinariaSplay noAux = no.getFilhoEsquerda();
        no.setFilhoEsquerda(noAux.getFilhoDireita());
        noAux.setFilhoDireita(no);
        return noAux;
    }

    public NoArvoreBinariaSplay rotacaoEsquerda(NoArvoreBinariaSplay no) {
        NoArvoreBinariaSplay noAux = no.getFilhoDireita();
        no.setFilhoDireita(noAux.getFilhoEsquerda());
        noAux.setFilhoEsquerda(no);
        return noAux;
    }

    public NoArvoreBinariaSplay getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvoreBinariaSplay raiz) {
        this.raiz = raiz;
    }

}

