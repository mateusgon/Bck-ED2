package arvores;

import java.util.ArrayList;
import java.util.List;
import model.Gasto;

public class Trie {

    private NoTrie raiz;
    private List<Gasto> sugestoes;

    public Trie() {
        this.raiz = new NoTrie(' ');
        this.sugestoes = new ArrayList<>();
    }

    public void inserir(Gasto gasto) {
        String palavra = gasto.getReceipt_description();
        Integer palavraTam = palavra.length();
        if (palavraTam == 0) {
            raiz.seteFimDaString(true);
        } else {
            Integer i = 0;
            NoTrie atual = raiz;
            NoTrie filho;
            while (i < palavraTam) {
                filho = atual.subNode(palavra.toUpperCase().charAt(i));
                if (filho == null) {
                    filho = new NoTrie(palavra.toUpperCase().charAt(i));
                    atual.getFilho().add(filho);
                }
                atual = filho;
                i++;
            }
            atual.seteFimDaString(true);
            if (atual.getGasto() == null) {
                atual.setGasto(gasto);
            } else {
                atual.getGasto().setReceipt_value(atual.getGasto().getReceipt_value() + gasto.getReceipt_value());
            }
        }
    }

    public NoTrie getLocalizacaoString(String palavra) {
        NoTrie atual = this.raiz;
        NoTrie filho;
        Integer palavraTam = palavra.length();
        Integer i = 0;
        while (i < palavraTam) {
            filho = atual.subNode(palavra.toUpperCase().charAt(i));
            if (filho != null) {
                atual = filho;
            } else {
                return atual;
            }
            i++;
        }
        if (i == palavraTam) {
            return atual;
        }
        return atual;
    }

    public void autocomplete(NoTrie no) {

        if (no.geteFimDaString()) {
            this.sugestoes.add(no.getGasto());
        }
        for (NoTrie filhoNo : no.getFilho()) {
            autocomplete(filhoNo);
        }

    }

    public NoTrie pesquisar(String palavra) {
        int palavraTam = palavra.length();
        if (palavraTam == 0) {
            return null;
        } else {
            int i = 0;
            NoTrie atual = raiz, filho;
            while (i < palavraTam) {
                filho = atual.subNode(palavra.charAt(i));
                if (filho != null) {
                    atual = filho;
                } else {
                    return null;
                }
                i++;
            }
            if (i == palavraTam) {
                return atual;
            }
        }
        return null;
    }

    public NoTrie getRaiz() {
        return raiz;
    }

    public void setRaiz(NoTrie raiz) {
        this.raiz = raiz;
    }

    public List<Gasto> getSugestoes() {
        return sugestoes;
    }

    public void setSugestoes(List<Gasto> sugestoes) {
        this.sugestoes = sugestoes;
    }

}
