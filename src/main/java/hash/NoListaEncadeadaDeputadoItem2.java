package hash;

public class NoListaEncadeadaDeputadoItem2 { // Responsável por armazenar os dados de deputados da Lista Encadeada do Item 2

    // Possui o nome do deputado, o nome do partido político, o id do deputado, o valor e um ponteiro para a próxima informação
    
    private String nomeDeputado;
    private String partido;
    private Integer deputy_id;
    private Integer valor;
    private NoListaEncadeadaDeputadoItem2 proximo;

    public NoListaEncadeadaDeputadoItem2() {
        this.nomeDeputado = null;
        this.deputy_id = -1;
        this.valor = 0;
        this.proximo = null;
    }

    public NoListaEncadeadaDeputadoItem2(String nomeDeputado, String partido, Integer deputy_id, Integer valor, NoListaEncadeadaDeputadoItem2 proximo) {
        this.nomeDeputado = nomeDeputado;
        this.deputy_id = deputy_id;
        this.valor = valor;
        this.proximo = proximo;
        this.partido = partido;
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

    public String getNomeDeputado() {
        return nomeDeputado;
    }

    public void setNomeDeputado(String nomeDeputado) {
        this.nomeDeputado = nomeDeputado;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

}
