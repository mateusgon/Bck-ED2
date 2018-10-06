package hash;

public class NoListaEncadeadaDeputadoItem2 {

    private String nomeDeputado;
    private Integer deputy_id;
    private Integer valor;
    private NoListaEncadeadaDeputadoItem2 proximo;

    public NoListaEncadeadaDeputadoItem2() {
        this.nomeDeputado = null;
        this.deputy_id = -1;
        this.valor = 0;
        this.proximo = null;
    }

    public NoListaEncadeadaDeputadoItem2(String nomeDeputado, Integer deputy_id, Integer valor, NoListaEncadeadaDeputadoItem2 proximo) {
        this.nomeDeputado = nomeDeputado;
        this.deputy_id = deputy_id;
        this.valor = valor;
        this.proximo = proximo;
    }

    public NoListaEncadeadaDeputadoItem2 getProximo() {
        return proximo;
    }

    public void setProximo(NoListaEncadeadaDeputadoItem2 proximo) {
        this.proximo = proximo;
    }

    public Integer getDeputy_id() {
        return deputy_id;
    }

    public void setDeputy_id(Integer deputy_id) {
        this.deputy_id = deputy_id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

}
