package model;

public class NoListaEncadeada {

    private Integer deputy_id;
    private NoListaEncadeada proximo;

    public NoListaEncadeada() {
        this.deputy_id = -1;
        this.proximo = null;
    }

    public NoListaEncadeada(Integer deputy_id, NoListaEncadeada proximo) {
        this.deputy_id = deputy_id;
        this.proximo = proximo;
    }

    public NoListaEncadeada getProximo() {
        return proximo;
    }

    public void setProximo(NoListaEncadeada proximo) {
        this.proximo = proximo;
    }

    public Integer getDeputy_id() {
        return deputy_id;
    }

    public void setDeputy_id(Integer deputy_id) {
        this.deputy_id = deputy_id;
    }

}
